package com.projeto.pousada.dto;

import com.projeto.pousada.domain.Categoria;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Preenchimento Obrigatório.")
    @Length(min = 5, max = 50, message = "Deve ter entre 5 e 50 caracteres")
    private String nomeCategoria;

    public CategoriaDTO(Categoria obj) {
        id = obj.getId();
        nomeCategoria = obj.getNomeCategoria();
    }

    public CategoriaDTO() {
    }
}
