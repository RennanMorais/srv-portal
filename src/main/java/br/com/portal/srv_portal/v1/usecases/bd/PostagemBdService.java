package br.com.portal.srv_portal.v1.usecases.bd;

import br.com.portal.srv_portal.v1.adapter.outbound.repository.PostagemRepository;
import br.com.portal.srv_portal.v1.domain.core.ImagemDomain;
import br.com.portal.srv_portal.v1.domain.core.PostagemDomain;
import br.com.portal.srv_portal.v1.domain.dto.response.ApiResponseDTO;
import br.com.portal.srv_portal.v1.domain.entity.ImagemEntity;
import br.com.portal.srv_portal.v1.domain.entity.PostagemEntity;
import br.com.portal.srv_portal.v1.port.outbound.PostagemRepositoryPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PostagemBdService implements PostagemRepositoryPort {

    private final PostagemRepository postagemRepository;

    @Override
    public ApiResponseDTO postar(PostagemDomain request) {
        PostagemEntity postagem = new PostagemEntity();
        postagem.setTitulo(request.getTitulo());
        postagem.setDescricao(request.getDescricao());
        postagem.setAutor(request.getAutor());
        postagem.setTexto(request.getTexto());
        postagem.setCategoria(request.getCategoria());
        postagem.setBackground(request.getBackground());
        postagem.setImagens(new ArrayList<>());

        for(ImagemDomain img : request.getImagens()) {
            ImagemEntity imagemEntity = new ImagemEntity();
            imagemEntity.setArquivo(img.getArquivo());
            imagemEntity.setPostagem(postagem);
            postagem.getImagens().add(imagemEntity);
        }

        postagemRepository.save(postagem);
        return ApiResponseDTO.builder()
                .codigo(String.valueOf(HttpStatus.OK.value()))
                .mensagem("Postagem realizada com sucesso").build();
    }

    @Transactional
    @Override
    public List<PostagemEntity> listarPostagem() {
        return postagemRepository.listarPostagens();
    }

}
