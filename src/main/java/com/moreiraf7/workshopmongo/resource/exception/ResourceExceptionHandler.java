package com.moreiraf7.workshopmongo.resource.exception;

import com.moreiraf7.workshopmongo.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice //Pega as exceção que acontecerem para que a classe possa tratar
public class ResourceExceptionHandler  {


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> notFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(Instant.now(), status.value(), "Object not found", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
