package br.com.caelum.mog.infra.entities;

import br.com.caelum.mog.domain.models.Cliente;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class ClienteEntity implements Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private ClienteEntity() { }

    public ClienteEntity(String nomeFantasia, String razaoSocial, String cnpj) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    @Override
    public String getRazaoSocial() {
        return razaoSocial;
    }

    @Override
    public String getCnpj() {
        return cnpj;
    }

}
