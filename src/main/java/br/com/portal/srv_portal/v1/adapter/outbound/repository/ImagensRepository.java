package br.com.portal.srv_portal.v1.adapter.outbound.repository;

import br.com.portal.srv_portal.v1.domain.entity.ImagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImagensRepository extends JpaRepository<ImagemEntity, UUID> {
}
