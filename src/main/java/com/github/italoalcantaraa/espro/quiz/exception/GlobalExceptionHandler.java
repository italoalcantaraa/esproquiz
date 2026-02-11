package com.github.italoalcantaraa.espro.quiz.exception;

import com.github.italoalcantaraa.espro.quiz.dto.error.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidUserDataException(UserDataException error) {
        ErrorResponse errorResponse = new ErrorResponse(error.getMessage());
        return ResponseEntity.status(400).body(errorResponse);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handledUserNotFoundException(UserNotFoundException error) {
        ErrorResponse errorResponse = new ErrorResponse(error.getMessage());
        return ResponseEntity.status(404).body(errorResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException error) {
        ErrorResponse errorResponse = new ErrorResponse(error.getMessage());
        return ResponseEntity.status(404).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorResponse> handlExeption(Exception error) {
        ErrorResponse errorResponse = new ErrorResponse("Erro inesperado );");
        return ResponseEntity.status(404).body(errorResponse);
    }
}
