package com.car_repairshop.rest_api;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
      HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest) {

    // Creating a LinkedHashMap to store the timestamp, status and errors
    Map<String, Object> objectBody = new LinkedHashMap<>();
    objectBody.put("Current Timestamp", new Date());
    objectBody.put("Status", httpStatus.value());

    // Get all errors
    List<String> exceptionalErrors = exception.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(x -> x.getDefaultMessage())
        .collect(Collectors.toList());

    objectBody.put("Errors", exceptionalErrors);

    // Return the response entity with the body and status
    return new ResponseEntity<>(objectBody, httpStatus);
  }
}
