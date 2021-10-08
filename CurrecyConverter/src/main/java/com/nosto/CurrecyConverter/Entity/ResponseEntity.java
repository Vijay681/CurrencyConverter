package com.nosto.CurrecyConverter.Entity;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ResponseEntity {

    private Double convertedValue;
    private Date dateTime;
    private HttpStatus httpStatus;

    public ResponseEntity(Double convertedValue, Date dateTime, HttpStatus httpStatus) {
        this.convertedValue = convertedValue;
        this.dateTime = dateTime;
        this.httpStatus = httpStatus;
    }

    public Double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(Double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
