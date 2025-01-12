package br.com.portal.srv_portal.v1.domain.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponseDTO {

    private String codigo;
    private String mensagem;

}
