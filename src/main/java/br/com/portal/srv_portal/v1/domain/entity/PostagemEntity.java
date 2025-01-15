package br.com.portal.srv_portal.v1.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Table(name = "postagens")
@Entity
@Data
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
}
