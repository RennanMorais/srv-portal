package br.com.portal.srv_portal.v1.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Table(name = "postagens")
@Entity
public class PostagemEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "autor")
    private String autor;

    @Column(name = "texto")
    private String texto;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "background")
    private String background;

    @OneToMany
    @JoinColumn(name = "idpostagem")
    private List<ImagemEntity> imagens;

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

    public List<ImagemEntity> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemEntity> imagens) {
        this.imagens = imagens;
    }
}
