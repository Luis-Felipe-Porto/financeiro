package com.api.pagamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends Throwable{
    public UserNotFoundException(String mensagem) {
        super(mensagem);
    }
}