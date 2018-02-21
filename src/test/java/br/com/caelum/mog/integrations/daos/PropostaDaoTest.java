package br.com.caelum.mog.integrations.daos;

import br.com.caelum.mog.domain.models.Cliente;
import br.com.caelum.mog.domain.models.Curso;
import br.com.caelum.mog.domain.models.Proposta;
import br.com.caelum.mog.domain.repositories.PropostaRepository;
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
import java.time.Period;
import java.util.List;

import static com.spotify.hamcrest.optional.OptionalMatchers.emptyOptional;
import static com.spotify.hamcrest.optional.OptionalMatchers.optionalWithValue;
import static com.spotify.hamcrest.pojo.IsPojo.pojo;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@SpringBootTest
@DataJpaTest
@RunWith(SpringRunner.class)
@Transactional
public class PropostaDaoTest {


    @Autowired
    private TestEntityManager manager;

    @Autowired
    private PropostaRepository propostaRepository;


    @Test
    public void deveSerPossivelRetornarUmaPropostaAtravesDoId(){

        Curso fj11 = new Curso("FJ 11 - Java e Orientação a Objetos", new BigDecimal("2290"), Duration.ofHours(40));
        Curso fj21 = new Curso("FJ 21 - Java Para Desenvolvimento Web", new BigDecimal("2290"), Duration.ofHours(40));
        Cliente cdc = new Cliente("CDC", "Casa do Código", "11.111.111/1111-11");


        manager.persist(fj11);
        manager.persist(fj21);
        manager.persist(cdc);

        Long id = manager.persistAndGetId(new Proposta(cdc, Period.ofWeeks(2), fj11, fj21), Long.class);


        assertThat(propostaRepository.findById(id), is(optionalWithValue(pojo(Proposta.class)
                                                            .where(Proposta::getId, is(equalTo(id)))
                                                            .where(Proposta::getCursos, contains(fj11, fj21))
                                                            .where(Proposta::getPeriodo, is(Period.ofWeeks(2)))
                                                            .where(Proposta::getCliente, is(cdc))
                                                            .where(Proposta::getTotal, is(new BigDecimal("4580")))
        )));
    }


    public void deveSerRetornadoUmOptionalVazioQuandoOIdNaoExistir(){
        assertThat(propostaRepository.findById(500L), is(emptyOptional()));
    }
}
