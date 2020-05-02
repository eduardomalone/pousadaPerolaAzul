package com.projeto.pousada.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Getter
@Setter
@Entity
public class Aposento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private Double valor;
    private int numero;

    /*@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "aposento_id")*/
    private Categoria categoria;

    @JsonIgnore
    public List<Hospedagem> getHospedagens(){
        List<Hospedagem> lista = new ArrayList();
        for (ItemHospedagem x : itens ) {
            lista.add(x.getHospedagem());
        }
        return lista;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "id.aposento")
    private Set<ItemHospedagem> itens = new HashSet<>();

    public Set<ItemHospedagem> getItens() {
        return itens;
    }

    @OneToMany(mappedBy = "id.aposento")
    public void setItens(Set<ItemHospedagem> itens) {
        this.itens = itens;
    }

    public Aposento() {
    }

    public Aposento(Integer id, String descricao, Double valor, int numero) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aposento aposento = (Aposento) o;
        return id.equals(aposento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
