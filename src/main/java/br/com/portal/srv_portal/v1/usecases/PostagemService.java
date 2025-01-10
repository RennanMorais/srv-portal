package br.com.portal.srv_portal.v1.usecases;

import br.com.portal.srv_portal.v1.domain.dto.request.PostagemRequestDTO;
import br.com.portal.srv_portal.v1.domain.dto.response.PostagemResponseDTO;
import br.com.portal.srv_portal.v1.port.inbound.PostagemPort;
import br.com.portal.srv_portal.v1.port.outbound.PostagemRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostagemService implements PostagemPort {

    @Autowired
    private PostagemRepositoryPort postagemRepositoryPort;

    @Override
    public String postar(PostagemRequestDTO request) {
        return postagemRepositoryPort.postar(request);
    }

    @Override
    public List<PostagemResponseDTO> listarPostagens() {
        return postagemRepositoryPort.listarPostagem();
    }
}
