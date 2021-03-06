package com.projeto.pousada.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Data
@Entity
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cargo;
    private double salario;
    private String cpf;
    private String telefone;

    public Funcionario(){};

    public Funcionario(Integer id, String nome, String cargo, double salario, String cpf, String telefone) {
        super();
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
