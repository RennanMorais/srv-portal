package br.com.portal.srv_portal.v1.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroDTO {

    private int codigo;
    private String mensagem;

}
