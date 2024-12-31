package br.com.portal.srv_portal.v1.adapter.inbound.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/portal")
public class PostController {

    @PostMapping("/postagem/postar")
    public String postar() {
        return "Sucesso!";
    }

}
