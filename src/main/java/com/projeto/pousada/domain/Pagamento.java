package com.projeto.pousada.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.pousada.domain.enums.EstadoPagamento;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  abstract class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Integer estado;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="hospedagem_id")
    @MapsId
    private  Hospedagem hospedagem;

    public Pagamento() {
    }

    public Pagamento(Integer id, EstadoPagamento estado, Hospedagem hospedagem) {
        super();
        this.id = id;
        this.estado = (estado==null) ? null : estado.getCod();
        this.hospedagem = hospedagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return id.equals(pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
