package com.projeto.pousada.domain;

import com.projeto.pousada.domain.enums.EstadoPagamento;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Objects;

@Data
@Entity
public class PagamentoComCartao extends Pagamento {

    private static final long serialVersionUID = 1L;

    private Integer numeroDeParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Hospedagem hospedagem, Integer numeroDeParcelas) {
        super(id, estado, hospedagem);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PagamentoComCartao that = (PagamentoComCartao) o;
        return Objects.equals(numeroDeParcelas, that.numeroDeParcelas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numeroDeParcelas);
    }
}
