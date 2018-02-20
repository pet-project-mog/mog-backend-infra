package br.com.caelum.mog.infra.daos;

import br.com.caelum.mog.domain.models.Proposta;
import br.com.caelum.mog.domain.repositories.PropostaRepository;
import org.springframework.data.repository.Repository;

public interface PropostaDao extends Repository<Proposta, Long>, PropostaRepository {
}
