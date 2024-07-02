package com.blackcode.helpdesk.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

// nome da classe era pra ser ResourceExceptionHandler
// Manipulador de exceções

@ControllerAdvice
public class ResourceExceptionHandlerController {

    @ExceptionHandler(ObjectNotFoundExceptionService.class)
    public ResponseEntity<StandardErrorController> objectNotFoundExceptionService(ObjectNotFoundExceptionService ex,
            HttpServletRequest request) {
        StandardErrorController err = new StandardErrorController(
                System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(),
                "Objeto não encontrado!",
                ex.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardErrorController> dataIntegrityViolationException(DataIntegrityViolationException ex,
            HttpServletRequest request) {
        StandardErrorController err = new StandardErrorController(
                System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                "Violação da integridade dos dados!",
                ex.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardErrorController> validationErrors(MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        ValidationError err = new ValidationError(
                System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                "Validation Error!!",
                "Erro na validação dos campos!",
                request.getRequestURI());

        // laço for para percorrer a lista de erros e adicionar na lista de erros do
        // ValidationError
        // ex.getBindingResult().getFieldErrors().forEach(e -> {
        // err.addError(e.getField(), e.getDefaultMessage());
        // });
        for (FieldError e : ex.getBindingResult().getFieldErrors()) {
            err.addError(e.getField(), e.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
