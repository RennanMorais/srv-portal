package br.com.portal.srv_portal.v1.domain.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ImagemRequestDTO {

    @NotNull(message = "{validacao.valor.nulo}")
    @NotEmpty(message = "{validacao.valor.vazio}")
    private String arquivo;

}
