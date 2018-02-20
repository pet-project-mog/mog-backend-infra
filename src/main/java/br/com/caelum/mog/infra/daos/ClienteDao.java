package br.com.caelum.mog.infra.daos;

import br.com.caelum.mog.domain.repositories.ClienteRepository;
import br.com.caelum.mog.infra.entities.ClienteEntity;
import org.springframework.data.repository.Repository;

public interface ClienteDao extends Repository<ClienteEntity, Long>, ClienteRepository {
}
