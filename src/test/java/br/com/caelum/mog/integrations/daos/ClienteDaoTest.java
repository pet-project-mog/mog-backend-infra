package br.com.caelum.mog.integrations.daos;

import br.com.caelum.mog.domain.models.Cliente;
import br.com.caelum.mog.domain.repositories.ClienteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static com.spotify.hamcrest.optional.OptionalMatchers.emptyOptional;
import static com.spotify.hamcrest.optional.OptionalMatchers.optionalWithValue;
import static com.spotify.hamcrest.pojo.IsPojo.pojo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
@DataJpaTest
@RunWith(SpringRunner.class)
@Transactional
public class ClienteDaoTest {

    @Autowired
    private TestEntityManager manager;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void deveSerPossivelRetornarUmClienteAtravesDoId(){
        Long id = manager.persistAndGetId(new Cliente("CDC", "Casa do Código", "11.111.111/1111-11"), Long.class);

        assertThat(clienteRepository.findById(id), is(optionalWithValue(pojo(Cliente.class)
                                                        .where(Cliente::getId, is(equalTo(id)))
                                                        .where(Cliente::getNomeFantasia, is("CDC"))
                                                        .where(Cliente::getRazaoSocial, is("Casa do Código"))
                                                        .where(Cliente::getCnpj, is("11.111.111/1111-11"))
        )));

    }

    @Test
    public void deveSerRetornadoUmOptionalVazioQuandoOIdNaoExistir(){
        assertThat(clienteRepository.findById(500L), is(emptyOptional()));
    }
}
