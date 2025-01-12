package br.com.portal.srv_portal.v1.domain.dto.request;

import lombok.*;

@Data
public class PostagemRequestDTO {
    private String titulo;
    private String descricao;
    private String autor;
    private String texto;
    private String categoria;
    private String background;
}
