package com.projeto.pousada.resources.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationError extends StandartError {

    private static final long serialVersionUI = 1L;

    private List<FieldMessage> errors = new ArrayList();

    public ValidationError(Integer status, String message, Long timeStamp) {
        super(status, message, timeStamp);
    }

    public void addError(String fieldName, String messasge){
        errors.add(new FieldMessage(fieldName, messasge));
    }
}
