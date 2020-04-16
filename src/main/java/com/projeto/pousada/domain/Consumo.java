package com.projeto.pousada.domain;

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
public class Consumo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descConsumo;
    private String dataHoraConsumo;
    private int qtdProdutoConsumido;

    Consumo(){};

    public Consumo(Integer id, String descConsumo, String dataHoraConsumo, int qtdProdutoConsumido) {
        this.id = id;
        this.descConsumo = descConsumo;
        this.dataHoraConsumo = dataHoraConsumo;
        this.qtdProdutoConsumido = qtdProdutoConsumido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumo that = (Consumo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
