package br.com.caelum.mog.infra.daos;

import br.com.caelum.mog.domain.repositories.PropostaRepository;
import br.com.caelum.mog.infra.entities.PropostaEntity;
import org.springframework.data.repository.Repository;

public interface PropostaDao extends Repository<PropostaEntity, Long>, PropostaRepository {
}
