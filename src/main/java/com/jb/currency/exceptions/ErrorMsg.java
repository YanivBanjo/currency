package com.jb.currency.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorMsg {
    HttpStatus statusCode;
    String msg;
}
