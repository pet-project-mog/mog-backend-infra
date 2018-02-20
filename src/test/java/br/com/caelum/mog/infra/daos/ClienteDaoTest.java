package br.com.caelum.mog.infra.daos;

import br.com.caelum.mog.domain.models.Cliente;
import br.com.caelum.mog.domain.repositories.ClienteRepository;
import br.com.caelum.mog.infra.entities.ClienteEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static com.spotify.hamcrest.optional.OptionalMatchers.emptyOptional;
import static com.spotify.hamcrest.optional.OptionalMatchers.optionalWithValue;
import static com.spotify.hamcrest.pojo.IsPojo.pojo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
@DataJpaTest
@RunWith(SpringRunner.class)
@Transactional
public class ClienteDaoTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void deveSerPossivelRetornarUmClienteAtravesDoId(){
        clienteRepository.save(new ClienteEntity("CDC", "Casa do Código", "11.111.111/1111-11"));

        assertThat(clienteRepository.findById(1L), is(optionalWithValue(pojo(Cliente.class)
                                                        .where(Cliente::getId, is(1L))
                                                        .where(Cliente::getNomeFantasia, is("CDC"))
                                                        .where(Cliente::getRazaoSocial, is("Casa do Código"))
                                                        .where(Cliente::getCnpj, is("11.111.111/1111-11"))
        )));

    }

    @Test
    public void deveSerRetornadoUmOptionalVazioQuandoOIdNaoExistir(){
        assertThat(clienteRepository.findById(1L), is(emptyOptional()));
    }
}
