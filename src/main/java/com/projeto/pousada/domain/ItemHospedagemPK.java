package com.projeto.pousada.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class ItemHospedagemPK implements Serializable {

    private static final long serialVersionUID = 1L;


    @ManyToOne
    @JoinColumn(name = "aposento_id")
    private Aposento aposento;

    @ManyToOne
    @JoinColumn(name = "hospedagem_id")
    private Hospedagem hospedagem;

    public ItemHospedagemPK() {
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemHospedagemPK that = (ItemHospedagemPK) o;
        return hospedagem.equals(that.hospedagem) &&
                aposento.equals(that.aposento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospedagem, aposento);
    }
}
