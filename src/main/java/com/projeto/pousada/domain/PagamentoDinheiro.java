package com.projeto.pousada.domain;

import com.projeto.pousada.domain.enums.EstadoPagamento;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Objects;

@Data
@Entity
public class PagamentoDinheiro extends Pagamento {

    private static final long serialVersionUID = 1L;

    private Double valor;

    public PagamentoDinheiro() {
    }

    public PagamentoDinheiro(Integer id, EstadoPagamento estado, Hospedagem hospedagem) {
        super(id, estado, hospedagem);
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PagamentoDinheiro that = (PagamentoDinheiro) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), valor);
    }
}
