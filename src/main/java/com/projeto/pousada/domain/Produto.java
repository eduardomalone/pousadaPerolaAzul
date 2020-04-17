package com.projeto.pousada.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Data
@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeProduto;
    private Double precoProduto;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "PRODUTO_CATEGORIA",
                joinColumns = @JoinColumn(name = "produto_id"),
                inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> listaCategorias = new ArrayList<>();

    Produto(){};

    public Produto(Integer id, String nomeProduto, Double precoProduto) {
        super();
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto that = (Produto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
