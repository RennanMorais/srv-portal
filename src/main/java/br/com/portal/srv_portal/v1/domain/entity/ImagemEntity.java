package br.com.portal.srv_portal.v1.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Table(name = "imagens")
@Data
@Entity
public class ImagemEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "arquivo")
    private String arquivo;

    @ManyToOne
    @JoinColumn(name = "id_postagem")
    private PostagemEntity postagem;

}
