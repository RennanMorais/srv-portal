package br.com.portal.srv_portal.v1.port.inbound;

import br.com.portal.srv_portal.v1.domain.dto.request.PostagemRequestDTO;
import br.com.portal.srv_portal.v1.domain.dto.response.PostagemResponseDTO;

import java.util.List;

public interface PostagemPort {

    public String postar(PostagemRequestDTO request);

    public List<PostagemResponseDTO> listarPostagens();

}
