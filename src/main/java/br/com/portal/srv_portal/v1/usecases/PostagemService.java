package br.com.portal.srv_portal.v1.usecases;

import br.com.portal.srv_portal.v1.domain.core.PostagemDomain;
import br.com.portal.srv_portal.v1.domain.dto.response.ApiResponseDTO;
import br.com.portal.srv_portal.v1.domain.dto.response.PostagemResponseDTO;
import br.com.portal.srv_portal.v1.domain.entity.PostagemEntity;
import br.com.portal.srv_portal.v1.port.inbound.PostagemPort;
import br.com.portal.srv_portal.v1.port.outbound.PostagemRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostagemService implements PostagemPort {

    @Autowired
    private PostagemRepositoryPort postagemRepositoryPort;

    @Override
    public ApiResponseDTO postar(PostagemDomain request) {
        ApiResponseDTO response;

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
                        new ArrayList<>()
                ))
                .collect(Collectors.toList());
    }
}
