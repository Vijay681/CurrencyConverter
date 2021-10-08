package com.nosto.CurrecyConverter.Exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class ExceptionResponse {
    private String message;
    private Date dateTime;
    private HttpStatus httpStatus;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
