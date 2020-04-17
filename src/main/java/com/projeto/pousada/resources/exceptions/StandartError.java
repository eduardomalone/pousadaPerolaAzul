package com.projeto.pousada.resources.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandartError {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String message;
    private Long timeStamp;

    public StandartError(Integer status, String message, Long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
