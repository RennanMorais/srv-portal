package br.com.portal.srv_portal.v1.mapper;

import br.com.portal.srv_portal.v1.domain.core.PostagemDomain;
import br.com.portal.srv_portal.v1.domain.dto.request.PostagemRequestDTO;

public class PostagemDomainMapper {

    public static PostagemDomain mapearPostagemDomain(PostagemRequestDTO postagemRequestDTO) {
        PostagemDomain p = new PostagemDomain();
        p.setTitulo(postagemRequestDTO.getTitulo());
        p.setDescricao(postagemRequestDTO.getDescricao());
        p.setAutor(postagemRequestDTO.getAutor());
        p.setTexto(postagemRequestDTO.getTexto());
        p.setCategoria(postagemRequestDTO.getCategoria());
        p.setBackground(postagemRequestDTO.getBackground());
        return p;
    }

}
