package com.projeto.pousada.resources.exceptions;

import com.projeto.pousada.services.exceptions.DataIntegratyException;
import com.projeto.pousada.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){

        StandartError erro = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage() , System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(DataIntegratyException.class)
    public ResponseEntity<StandartError> dataIntegraty(DataIntegratyException e, HttpServletRequest request){

        StandartError erro = new StandartError(HttpStatus.BAD_REQUEST.value(), e.getMessage() , System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }


}
