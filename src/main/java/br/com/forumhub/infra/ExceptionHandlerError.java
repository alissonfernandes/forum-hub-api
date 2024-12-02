package br.com.forumhub.infra;
/*
* Classe reponsável por capturar e lidar com exceções
* */

import br.com.forumhub.domain.exception.ExistingTopicException;
import br.com.forumhub.domain.exception.NotExistsException;
import br.com.forumhub.domain.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandlerError {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity notFoundException(NotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var error = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream().map(ErrorValidData::new));
    }

    @ExceptionHandler(NotExistsException.class)
    public ResponseEntity notExists(NotExistsException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(ExistingTopicException.class)
    public ResponseEntity existingTopicException(ExistingTopicException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    private record ErrorValidData(String field, String message) {
        public ErrorValidData(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
