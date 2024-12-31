package br.com.portal.srv_portal.v1.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

}
