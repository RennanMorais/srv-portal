package br.com.portal.srv_portal.v1.adapter.outbound.repository;

import br.com.portal.srv_portal.v1.domain.dto.response.PostagemResponseDTO;
import br.com.portal.srv_portal.v1.domain.entity.PostagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemEntity, UUID> {

    @Procedure("SP_LISTAR_POSTAGENS")
    List<PostagemEntity> listarPostagens();

}
