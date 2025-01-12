package br.com.portal.srv_portal.v1.domain.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
public class PostagemRequestDTO {

    @Size(max = 300, message = "{validacao.max.300}")
    @NotNull(message = "{validacao.valor.nulo}")
    @NotEmpty
    private String titulo;


    @Size(max = 400, message = "{validacao.max.400}")
    @NotNull(message = "{validacao.valor.nulo}")
    @NotEmpty(message = "{validacao.valor.vazio}")
    private String descricao;

    @Size(max = 100, message = "{validacao.max.100}")
    @NotNull(message = "{validacao.valor.nulo}")
    @NotEmpty(message = "{validacao.valor.vazio}")
    private String autor;

    @NotNull(message = "{validacao.valor.nulo}")
    @NotEmpty(message = "{validacao.valor.vazio}")
    private String texto;

    @NotNull(message = "{validacao.valor.nulo}")
    @NotEmpty(message = "{validacao.valor.vazio}")
    private String categoria;

    @NotNull(message = "{validacao.valor.nulo}")
    @NotEmpty(message = "{validacao.valor.vazio}")
    private String background;

    @Valid
    @NotNull(message = "{validacao.valor.nulo}")
    @NotEmpty(message = "{validacao.valor.vazio}")
    private List<ImagemRequestDTO> imagens;

}
