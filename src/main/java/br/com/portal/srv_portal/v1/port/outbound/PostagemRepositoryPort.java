package br.com.portal.srv_portal.v1.port.outbound;

import br.com.portal.srv_portal.v1.domain.dto.request.PostRequestDTO;

public interface PostagemRepositoryPort {

    public void azerPostagem(PostRequestDTO request);

}
