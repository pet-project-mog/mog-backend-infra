package br.com.caelum.mog.infra.daos;

import br.com.caelum.mog.domain.models.Cliente;
import br.com.caelum.mog.domain.repositories.ClienteRepository;
import org.springframework.data.repository.Repository;

public interface ClienteDao extends Repository<Cliente, Long>, ClienteRepository {
}
