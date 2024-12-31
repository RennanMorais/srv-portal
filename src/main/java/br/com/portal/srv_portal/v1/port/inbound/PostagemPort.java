package br.com.portal.srv_portal.v1.port.inbound;

import br.com.portal.srv_portal.v1.domain.dto.request.PostRequestDTO;

public interface PostagemPort {

    public String postar(PostRequestDTO request);

}
