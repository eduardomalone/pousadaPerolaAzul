package com.projeto.pousada.dto;

import com.projeto.pousada.domain.Cliente;
import com.projeto.pousada.services.validantions.ClienteInsert;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 5, max = 50, message = "Deve ter entre 5 e 50 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Email(message = "Email invalido")
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente obj){

        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();

    }
}
