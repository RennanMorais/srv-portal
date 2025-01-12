package br.com.portal.srv_portal.v1.usecases.bd;

import br.com.portal.srv_portal.v1.adapter.outbound.repository.PostagemRepository;
import br.com.portal.srv_portal.v1.domain.core.PostagemDomain;
import br.com.portal.srv_portal.v1.domain.dto.response.ApiResponseDTO;
import br.com.portal.srv_portal.v1.domain.entity.PostagemEntity;
import br.com.portal.srv_portal.v1.port.outbound.PostagemRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostagemBdService implements PostagemRepositoryPort {

    @Autowired
    private PostagemRepository postagemRepository;

    @Override
    public ApiResponseDTO postar(PostagemEntity entity) {
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
