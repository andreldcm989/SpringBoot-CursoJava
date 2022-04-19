package com.cursojava.webservices.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.cursojava.webservices.services.exceptions.DatabaseException;
import com.cursojava.webservices.services.exceptions.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //intercepta as exceções para esse objeto tratar
public class ResourceExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class) //esse método intercepta exceções do tipo lançado e faz o tratamento dela
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class) //esse método intercepta exceções do tipo lançado e faz o tratamento dela
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
