package com.projeto.pousada.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StandartError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String message;
    @JsonFormat(pattern = "dd-MM-yyyyy")
    private Long timeStamp;

    public StandartError(Integer status, String message, Long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
