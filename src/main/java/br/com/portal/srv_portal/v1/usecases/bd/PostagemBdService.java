package br.com.portal.srv_portal.v1.usecases.bd;

import br.com.portal.srv_portal.v1.adapter.outbound.repository.PostagemRepository;
import br.com.portal.srv_portal.v1.domain.core.ImagemDomain;
import br.com.portal.srv_portal.v1.domain.core.PostagemDomain;
import br.com.portal.srv_portal.v1.domain.dto.response.ApiResponseDTO;
import br.com.portal.srv_portal.v1.domain.entity.ImagemEntity;
import br.com.portal.srv_portal.v1.domain.entity.PostagemEntity;
import br.com.portal.srv_portal.v1.port.outbound.PostagemRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostagemBdService implements PostagemRepositoryPort {

    @Autowired
    private PostagemRepository postagemRepository;

    @Override
    public ApiResponseDTO postar(PostagemDomain request) {
        PostagemEntity entity = new PostagemEntity();
        entity.setTitulo(request.getTitulo());
        entity.setDescricao(request.getDescricao());
        entity.setAutor(request.getAutor());
        entity.setTexto(request.getTexto());
        entity.setCategoria(request.getCategoria());
        entity.setBackground(request.getBackground());

        for(ImagemDomain img : request.getImagens()) {
            ImagemEntity imagemEntity = new ImagemEntity();
            imagemEntity.setArquivo(img.getArquivo());
            entity.setImagens(new ArrayList<>());
            entity.getImagens().add(imagemEntity);
        }

        postagemRepository.save(entity);
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
