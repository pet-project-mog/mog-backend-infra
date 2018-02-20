package br.com.caelum.mog.infra.entities;

import br.com.caelum.mog.domain.models.Cliente;
import br.com.caelum.mog.domain.models.Curso;
import br.com.caelum.mog.domain.models.Proposta;

import javax.persistence.*;
import java.time.Period;
import java.util.List;

@Entity
public class PropostaEntity implements Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<CursoEntity> cursos;

    @OneToOne
    private ClienteEntity cliente;
    private Period periodo;

    /**
     * @deprecated frameworks only
     */
    @Deprecated(since = "1.0.0")
    private PropostaEntity() { }

    public PropostaEntity(List<CursoEntity> cursos, ClienteEntity cliente, Period periodo) {
        this.cursos = cursos;
        this.cliente = cliente;
        this.periodo = periodo;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public List<? extends Curso> getCursos() {
        return cursos;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public Period getPeriodo() {
        return periodo;
    }
}
