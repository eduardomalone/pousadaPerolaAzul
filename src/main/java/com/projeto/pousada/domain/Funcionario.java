package com.projeto.pousada.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codigo;
    private String nome;
    private String cargo;
    private double salario;
    private String cpj;
    private String telefone;

    public Funcionario(){};

    public Funcionario(Integer codigo, String nome, String cargo, double salario, String cpj, String telefone) {

        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.cpj = cpj;
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }


}
