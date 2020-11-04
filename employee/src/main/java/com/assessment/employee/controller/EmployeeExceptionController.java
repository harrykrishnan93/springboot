package com.assessment.employee.controller;

import com.assessment.employee.constants.ServiceConstants;
import com.assessment.employee.exception.DataAlreadyExists;
import com.assessment.employee.exception.DataNotfoundException;
import com.assessment.employee.model.ErrorDetails;
import com.assessment.employee.model.ResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class EmployeeExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = DataNotfoundException.class)
    public ResponseEntity<ResponseDto> exception(DataNotfoundException exception) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(ServiceConstants.DATA_NOT_FOUND_CODE);
        responseDto.setMessage(ServiceConstants.DATA_NOT_FOUND_MESSAGE);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = DataAlreadyExists.class)
    public ResponseEntity<ResponseDto> exception(DataAlreadyExists exception) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode(ServiceConstants.DATA_ALREADY_EXISTS_CODE);
        responseDto.setMessage(ServiceConstants.DATA_ALREADY_EXISTS_MESSAGE);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.FORBIDDEN);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String,String> responseBody = new HashMap<>();
        responseBody.put("path",request.getContextPath());
        responseBody.put("message",ServiceConstants.URL_NOT_FOUND_MESSAGE);
        return new ResponseEntity<Object>(responseBody,HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST,ServiceConstants.REQUEST_BAD_CODE, errorList);
        return handleExceptionInternal(ex, errorDetails, headers, errorDetails.getStatus(), request);
    }

}
