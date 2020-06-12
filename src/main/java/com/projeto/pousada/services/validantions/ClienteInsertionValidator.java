package com.projeto.pousada.services.validantions;

import com.projeto.pousada.domain.Cliente;
import com.projeto.pousada.domain.enums.TipoCliente;
import com.projeto.pousada.dto.ClienteNewDTO;
import com.projeto.pousada.repositories.ClienteRepository;
import com.projeto.pousada.resources.exceptions.FieldMessage;
import com.projeto.pousada.services.validantions.util.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertionValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository repository;

    @Override
    public void initialize(ClienteInsert ann) {
    }
    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        // inclui os testes aqui, inserindo erros na lista
        if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) &&
                !BR.isValidCPF(objDto.getCpfCnpj())){
            list.add(new FieldMessage("cpfCnpj","CPF invalido"));
        }

        if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) &&
                !BR.isValidCNPJ(objDto.getCpfCnpj())){
            list.add(new FieldMessage("cpfCnpj","CNPJ invalido"));
        }

        Cliente aux = repository.findByEmail(objDto.getEmail());
        if(aux != null){
            list.add(new FieldMessage("email", "Email ja cadastrado!"));

        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}

