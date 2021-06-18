package com.jb.currency.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidCurrencyException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorMsg handleInvalidCurrencyException(InvalidCurrencyException ex) {
        return new ErrorMsg(BAD_REQUEST, ex.getMessage());
    }
}
