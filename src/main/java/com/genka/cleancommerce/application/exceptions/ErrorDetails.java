package com.genka.cleancommerce.application.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorDetails {

    private Date timestamp;
    private Integer code;
    private String status;
    private String message;

    public ErrorDetails(HttpStatus httpStatus, String message) {
        timestamp = new Date();
        code = httpStatus.value();
        status = httpStatus.name();
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
