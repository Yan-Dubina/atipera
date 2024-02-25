package com.example.atipera.exceptions.handler;

import com.example.atipera.exceptions.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

@RestControllerAdvice
public class AppExceptionHandler {


    @ExceptionHandler
    public ExceptionResponse handle(RuntimeException e) {

        if (e instanceof HttpStatusCodeException) {
            return new ExceptionResponse(((HttpStatusCodeException) e).getStatusCode().value(), ((HttpStatusCodeException) e).getStatusText());
        } else {
            return new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        }

    }
}
