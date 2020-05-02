package com.projeto.pousada.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Data
@Entity
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double valorTotal;
    private boolean pago;

    @OneToMany(mappedBy = "conta")
    private List<Consumo> listaConsumo;

    private  Hospedagem hospedagemConta;

    Conta(){};

    public Conta(Integer id, Double valorTotal, boolean pago, Hospedagem hospedagem) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.pago = pago;
        this.hospedagemConta = hospedagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return id.equals(conta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
