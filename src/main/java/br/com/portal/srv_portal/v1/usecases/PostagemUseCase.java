package br.com.portal.srv_portal.v1.usecases;

import br.com.portal.srv_portal.util.imagem.ImagemUtil;
import br.com.portal.srv_portal.v1.domain.core.PostagemDomain;
import br.com.portal.srv_portal.v1.domain.dto.response.ApiResponseDTO;
import br.com.portal.srv_portal.v1.domain.dto.response.ImagemResponseDTO;
import br.com.portal.srv_portal.v1.domain.dto.response.PostagemResponseDTO;
import br.com.portal.srv_portal.v1.domain.entity.ImagemEntity;
import br.com.portal.srv_portal.v1.domain.entity.PostagemEntity;
import br.com.portal.srv_portal.v1.port.inbound.PostagemPort;
import br.com.portal.srv_portal.v1.port.outbound.PostagemRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostagemUseCase implements PostagemPort {

    private final PostagemRepositoryPort postagemRepositoryPort;

    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024; // 5 MB

    @Override
    public ApiResponseDTO postar(PostagemDomain request) throws IOException {
        ApiResponseDTO response;
        byte[] backgroundBytes = Base64.getDecoder().decode(request.getBackground());

        if(backgroundBytes.length > MAX_FILE_SIZE) {
            return ApiResponseDTO.builder()
                    .codigo(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                    .mensagem("Tamanho do arquivo de background é maior do que 5mb").build();
        }

        String pathBackground = "imagens/background/" + ImagemUtil.gerarNomeImagemPng();
        Files.write(Path.of(pathBackground), backgroundBytes);
        request.setBackground(pathBackground);

        for(int i = 0; i < request.getImagens().size(); i++) {
            byte[] imagemBytes = Base64.getDecoder().decode(request.getImagens().get(i).getArquivo());
            if(imagemBytes.length > MAX_FILE_SIZE) {
                return ApiResponseDTO.builder()
                        .codigo(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .mensagem("Tamanho da Imagem é maior do que 5mb").build();
            }
            String path = "imagens/posts/" + ImagemUtil.gerarNomeImagemPng();
            Files.write(Path.of(path), imagemBytes);
            request.getImagens().get(i).setArquivo(path);
        }

        try {
            response = postagemRepositoryPort.postar(request);
        } catch (RuntimeException ex) {
            throw ex;
        }

        return response;
    }

    @Override
    public List<PostagemResponseDTO> listarPostagens() {
        List<PostagemEntity> postagens = postagemRepositoryPort.listarPostagem();
        return postagens.stream()
                .map(p -> new PostagemResponseDTO(
                        p.getId(),
                        p.getTitulo(),
                        p.getDescricao(),
                        p.getAutor(),
                        p.getTexto(),
                        p.getCategoria(),
                        p.getBackground(),
                        p.getImagens().stream()
                                .map(i -> ImagemResponseDTO.builder()
                                        .arquivo(i.getArquivo())
                                        .build()
                                ).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}
