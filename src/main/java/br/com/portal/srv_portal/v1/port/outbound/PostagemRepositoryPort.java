package br.com.portal.srv_portal.v1.port.outbound;

import br.com.portal.srv_portal.v1.domain.dto.request.PostagemRequestDTO;
import br.com.portal.srv_portal.v1.domain.dto.response.PostagemResponseDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface PostagemRepositoryPort {

    public String postar(PostagemRequestDTO request);

    public List<PostagemResponseDTO> listarPostagem();

}
