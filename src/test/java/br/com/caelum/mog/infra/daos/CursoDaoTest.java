package br.com.caelum.mog.infra.daos;

import br.com.caelum.mog.domain.models.Curso;
import br.com.caelum.mog.domain.repositories.CursoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Duration;

import static com.spotify.hamcrest.optional.OptionalMatchers.emptyOptional;
import static com.spotify.hamcrest.optional.OptionalMatchers.optionalWithValue;
import static com.spotify.hamcrest.pojo.IsPojo.pojo;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
@DataJpaTest
@RunWith(SpringRunner.class)
@Transactional
public class CursoDaoTest {

    @Autowired
    private TestEntityManager manager;

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    public void deveSerPossivelRetornarUmCursoAtravesDoId(){
        Long id = manager.persistAndGetId(new Curso("FJ 11 - Java e Orientação a Objetos", new BigDecimal("2290"), Duration.ofHours(40)), Long.class);


        assertThat(cursoRepository.findById(id), is(optionalWithValue(pojo(Curso.class)
                                                        .where(Curso::getId, is(equalTo(id)))
                                                        .where(Curso::getNome, is("FJ 11 - Java e Orientação a Objetos"))
                                                        .where(Curso::getValor, is(new BigDecimal("2290")))
                                                        .where(Curso::getCargaHoraria, is(Duration.ofHours(40))))));

    }


    @Test
    public void deveSerRetornadoUmOptionalVazioQuandoOIdNaoExistir(){
        assertThat(cursoRepository.findById(500L), is(emptyOptional()));
    }
}
