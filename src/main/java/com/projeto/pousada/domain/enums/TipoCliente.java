package com.projeto.pousada.domain.enums;

import lombok.Getter;

@Getter
public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Fisica"),
    PESSOAJURIDICA(2, "Pessoa Juridica");

    private int cod;
    private String descricao;

    private TipoCliente(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public static TipoCliente toEnum(Integer cod) throws IllegalAccessException {
        if (cod == null) {
            return null;
        }
        for (TipoCliente x : TipoCliente.values()){
            if(cod.equals(x.getCod())){
                return x;
            }

        }
        throw new IllegalAccessException("Id invalido" + cod);
    }
}
