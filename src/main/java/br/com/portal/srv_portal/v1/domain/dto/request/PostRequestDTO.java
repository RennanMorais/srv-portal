package br.com.portal.srv_portal.v1.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRequestDTO {

    private String titulo;
    private String descricao;
    private String autor;
    private String texto;
    private String categoria;

}
