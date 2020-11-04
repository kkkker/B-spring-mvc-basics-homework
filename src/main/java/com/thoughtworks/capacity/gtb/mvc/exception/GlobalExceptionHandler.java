package com.thoughtworks.capacity.gtb.mvc.exception;

import com.thoughtworks.capacity.gtb.mvc.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException exception) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(UsernameExistException.class)
    public ResponseEntity<ErrorResponse> handle(UsernameExistException exception) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
