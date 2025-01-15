package br.com.portal.srv_portal.v1.port.inbound;

import br.com.portal.srv_portal.v1.domain.core.PostagemDomain;
import br.com.portal.srv_portal.v1.domain.dto.response.ApiResponseDTO;
import br.com.portal.srv_portal.v1.domain.dto.response.PostagemResponseDTO;

import java.io.IOException;
import java.util.List;

public interface PostagemPort {

    public ApiResponseDTO postar(PostagemDomain request) throws IOException;

    public List<PostagemResponseDTO> listarPostagens();

}
