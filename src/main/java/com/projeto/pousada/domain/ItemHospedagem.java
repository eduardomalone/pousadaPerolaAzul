package com.projeto.pousada.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
public class ItemHospedagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ItemHospedagemPK id = new ItemHospedagemPK();
    private Double desconto;
    private int qtd;
    private Double preco;

    public ItemHospedagem() {
    }

    public ItemHospedagem(Aposento aposento, Hospedagem hospedagem, Double desconto, int qtd, Double preco) {
        id.setAposento(aposento);
        id.setHospedagem(hospedagem);
        this.desconto = desconto;
        this.qtd = qtd;
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemHospedagem that = (ItemHospedagem) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //@JsonIgnore
    public Aposento getAposento(){
        return id.getAposento();
    }

    @JsonIgnore
    public Hospedagem getHospedagem(){
        return id.getHospedagem();
    }
}
