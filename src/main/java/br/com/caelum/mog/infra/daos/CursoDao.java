package br.com.caelum.mog.infra.daos;

import br.com.caelum.mog.domain.repositories.CursoRepository;
import br.com.caelum.mog.infra.entities.CursoEntity;
import org.springframework.data.repository.Repository;

public interface CursoDao extends Repository<CursoEntity, Long>, CursoRepository {
}
