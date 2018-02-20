package br.com.caelum.mog.infra.entities;

import br.com.caelum.mog.domain.models.Curso;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.Duration;

@Entity
public class CursoEntity implements Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valor;
    private Duration cargaHoraria;

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private CursoEntity() {}

    public CursoEntity(String nome, BigDecimal valor, Duration cargaHoraria) {
        this.nome = nome;
        this.valor = valor;
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public Duration getCargaHoraria() {
        return cargaHoraria;
    }

}
