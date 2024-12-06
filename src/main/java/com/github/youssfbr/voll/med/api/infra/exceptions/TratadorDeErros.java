package com.github.youssfbr.voll.med.api.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    private static final HttpStatus notFound = HttpStatus.NOT_FOUND;

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> tratarErro404() { return ResponseEntity.notFound().build(); }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e , HttpServletRequest request) {
        StandardError err = new StandardError(Instant.now() , notFound.value() , "Recurso não encontrado" ,
                e.getMessage() , request.getRequestURI());
        return ResponseEntity.status(notFound).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErroValidacao>> tratarErro400(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest()
                .body(ex.getFieldErrors()
                        .stream()
                        .map(DadosErroValidacao::new)
                        .toList());
    }

    public record DadosErroValidacao(String campo , String mensagem) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField() , erro.getDefaultMessage());
        }
    }

}
