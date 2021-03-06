package com.nosto.CurrecyConverter.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestException  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CurrencyNotFoundException.class)
    public ResponseEntity<Object> handleCurrencyNotFoundExceptions( CurrencyNotFoundException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(Date.valueOf(LocalDate.now()));
        response.setMessage(exception.getMessage());
        response.setHttpStatus(HttpStatus.NOT_FOUND);
        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        return entity;
    }
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(Date.valueOf(LocalDate.now()));
        response.setMessage(ex.getMessage());
        response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}