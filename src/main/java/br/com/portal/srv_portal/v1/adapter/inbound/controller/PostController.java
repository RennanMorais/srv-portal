package br.com.portal.srv_portal.v1.adapter.inbound.controller;

import br.com.portal.srv_portal.v1.domain.dto.request.PostagemRequestDTO;
import br.com.portal.srv_portal.v1.domain.dto.response.ApiResponseDTO;
import br.com.portal.srv_portal.v1.domain.dto.response.PostagemResponseDTO;
import br.com.portal.srv_portal.v1.mapper.PostagemDomainMapper;
import br.com.portal.srv_portal.v1.port.inbound.PostagemPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/portal")
public class PostController {

    @Autowired
    private PostagemPort postagemPort;

    @PostMapping("/postagem/postar")
    public ResponseEntity<ApiResponseDTO> postar(@RequestBody PostagemRequestDTO request) {
        return ResponseEntity.ok(this.postagemPort.postar(
                PostagemDomainMapper.mapearPostagemDomain(request)));
    }

    @GetMapping("/postagem/listar")
    public ResponseEntity<List<PostagemResponseDTO>> listarPostagens() {
        return ResponseEntity.ok(this.postagemPort.listarPostagens());
    }

}
