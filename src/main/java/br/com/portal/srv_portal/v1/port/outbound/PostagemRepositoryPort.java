package br.com.portal.srv_portal.v1.port.outbound;

import br.com.portal.srv_portal.v1.domain.dto.response.ApiResponseDTO;
import br.com.portal.srv_portal.v1.domain.entity.PostagemEntity;

import java.util.List;

public interface PostagemRepositoryPort {

    public ApiResponseDTO postar(PostagemEntity request);

    public List<PostagemEntity> listarPostagem();

}
