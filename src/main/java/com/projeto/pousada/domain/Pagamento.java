package com.projeto.pousada.domain;

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
    @OneToOne
    @JoinColumn(name="hospedagem_id")
    @MapsId
    private  Hospedagem hospedagem;

    public Pagamento() {
    }

    public Pagamento(Integer id, EstadoPagamento estado, Hospedagem hospedagem) {
        this.id = id;
        this.estado = estado.getCod();
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
