package com.projeto.pousada.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Hospedagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instanteEntrada;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instanteSaida;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "hospedagem")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    Cliente cliente;

    @OneToMany(mappedBy = "id.hospedagem")
    private Set<ItemHospedagem> itens = new HashSet<>();

    public Hospedagem() {
    }

    public Hospedagem(Integer id, Date instanteEntrada, Date instanteSaida, Cliente cliente) {
        this.id = id;
        this.instanteEntrada = instanteEntrada;
        this.instanteSaida = instanteSaida;
        //this.aposento = aposento;
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospedagem that = (Hospedagem) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Set<ItemHospedagem> getItens() {
        return itens;
    }

    public void setItens(Set<ItemHospedagem> itens) {
        this.itens = itens;
    }
}
