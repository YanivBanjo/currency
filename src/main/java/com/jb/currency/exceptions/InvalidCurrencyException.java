package com.jb.currency.exceptions;

public class InvalidCurrencyException extends RuntimeException {
    public InvalidCurrencyException(String msg) {
        super(msg);
    }
}
