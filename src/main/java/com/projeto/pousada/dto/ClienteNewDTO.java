package com.projeto.pousada.dto;

import com.projeto.pousada.services.validantions.ClienteInsert;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@ClienteInsert
public class ClienteNewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 5, max = 50, message = "Deve ter entre 5 e 50 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Email(message = "Email invalido")
    private String email;

    @NotEmpty(message = "Preenchimento Obrigatório")
    private String cpfCnpj;

    private Integer tipo;

    @NotEmpty(message = "Preenchimento Obrigatório")
    private String logradouro;

    @NotEmpty(message = "Preenchimento Obrigatório")
    private String numero;

    private String complemento;

    private String bairro;

    @NotEmpty(message = "Preenchimento Obrigatório")
    private String cep;

    @NotEmpty(message = "Preenchimento Obrigatório")
    private String telefone1;

    private String telefone2;

    private String telefone3;

    private Integer cidade;

    public ClienteNewDTO(){}
}
