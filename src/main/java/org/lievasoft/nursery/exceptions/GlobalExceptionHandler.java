package org.lievasoft.nursery.exceptions;

import jakarta.persistence.EntityExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorValidationResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });

        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new ErrorValidationResponse(errors));
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ErrorResponse> handleEntityExistsException(EntityExistsException ex, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(
                request.getServletPath(),
                ex.getMessage(),
                LocalDateTime.now(ZoneId.of("America/La_Paz"))
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }
}
