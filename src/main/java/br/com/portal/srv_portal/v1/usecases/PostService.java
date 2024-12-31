package br.com.portal.srv_portal.v1.usecases;

import br.com.portal.srv_portal.v1.adapter.outbound.repository.PostagemRepository;
import br.com.portal.srv_portal.v1.domain.dto.request.PostRequestDTO;
import br.com.portal.srv_portal.v1.port.inbound.PostagemPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements PostagemPort {

    @Override
    public String postar(PostRequestDTO request) {
        return "";
    }

}
