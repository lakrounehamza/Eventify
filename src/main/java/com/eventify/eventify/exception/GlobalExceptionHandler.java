package com.eventify.eventify.exception;

import com.eventify.eventify.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
        ErrorResponse response = new ErrorResponse();
        String errors = e.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        response.setError(errors);
        response.setStatus(400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(NotFoundException.class)
    public  ResponseEntity<ErrorResponse>  handleNotFoundEception(NotFoundException e)
    {
        ErrorResponse response =  new ErrorResponse();
        response.setStatus(404);
        response.setMessage(e.getMessage());
        response.setTimestamp(Instant.now());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }

}
