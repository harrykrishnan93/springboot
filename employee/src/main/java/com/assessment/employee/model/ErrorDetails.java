package com.assessment.employee.model;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ErrorDetails {
    private HttpStatus status;
    private String code;
    private List<String> errors;

    public ErrorDetails(HttpStatus status , String code, List<String> errors) {
        super();
        this.status = status;
        this.errors = errors;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}