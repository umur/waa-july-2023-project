package com.twohundred.alumni.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.twohundred.alumni.entity.dto.response.ErrorResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(
            ServiceException e) {
        return new ResponseEntity<>(
                new ErrorResponse(e.getCode(), e.getMessage()), e.getStatus());
    }
}
