package br.com.portal.srv_portal.v1.usecases.bd;

import br.com.portal.srv_portal.v1.adapter.outbound.repository.PostagemRepository;
import br.com.portal.srv_portal.v1.domain.dto.request.PostagemRequestDTO;
import br.com.portal.srv_portal.v1.domain.dto.response.PostagemResponseDTO;
import br.com.portal.srv_portal.v1.domain.entity.PostagemEntity;
import br.com.portal.srv_portal.v1.port.outbound.PostagemRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostagemBdService implements PostagemRepositoryPort {

    @Autowired
    private PostagemRepository postagemRepository;

    @Override
    public String postar(PostagemRequestDTO request) {

        PostagemEntity entity = new PostagemEntity();

        entity.setTitulo(request.getTitulo());
        entity.setDescricao(request.getDescricao());
        entity.setAutor(request.getAutor());
        entity.setTexto(request.getTexto());
        entity.setCategoria(request.getCategoria());

        postagemRepository.save(entity);

        return "Postagem realizada com sucesso";
    }

    @Transactional
    @Override
    public List<PostagemResponseDTO> listarPostagem() {
        List<PostagemEntity> postagens = postagemRepository.listarPostagens();

        if(postagens == null || postagens.isEmpty()) {
            throw new RuntimeException("Nenhuma postagem encontrada");
        }

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
