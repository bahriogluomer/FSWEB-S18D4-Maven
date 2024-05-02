package com.workintech.s18d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@AllArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleException(BurgerException exception) {
        log.error( exception.getMessage());
        BurgerErrorResponse response = new BurgerErrorResponse(exception.getMessage());
        return ResponseEntity.status(exception.getHttpStatus()).body(response);
    }

    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleException(Exception exception) {
        log.error( exception.getMessage());
        BurgerErrorResponse response = new BurgerErrorResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
