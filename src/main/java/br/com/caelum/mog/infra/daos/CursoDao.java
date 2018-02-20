package br.com.caelum.mog.infra.daos;

import br.com.caelum.mog.domain.models.Curso;
import br.com.caelum.mog.domain.repositories.CursoRepository;
import org.springframework.data.repository.Repository;

public interface CursoDao extends Repository<Curso, Long>, CursoRepository {

}
