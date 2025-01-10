package br.com.portal.srv_portal.v1.domain.dto.response;

import br.com.portal.srv_portal.v1.domain.entity.ImagemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

public class PostagemResponseDTO {

    private UUID id;
    private String titulo;
    private String descricao;
    private String autor;
    private String texto;
    private String categoria;
    private String background;
    private List<ImagemResponseDTO> imagens;

    public PostagemResponseDTO(UUID id, String titulo, String descricao, String autor, String texto, String categoria, String background, List<ImagemResponseDTO> imagens) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.autor = autor;
        this.texto = texto;
        this.categoria = categoria;
        this.background = background;
        this.imagens = imagens;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<ImagemResponseDTO> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemResponseDTO> imagens) {
        this.imagens = imagens;
    }
}
