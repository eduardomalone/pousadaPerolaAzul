package com.projeto.pousada.dto;

import com.projeto.pousada.domain.Categoria;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nomeCategoria;

    public CategoriaDTO(Categoria obj) {
        id = obj.getId();
        nomeCategoria = obj.getNomeCategoria();
    }

    public CategoriaDTO() {
    }
}
