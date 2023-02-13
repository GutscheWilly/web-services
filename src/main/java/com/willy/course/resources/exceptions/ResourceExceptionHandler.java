package com.willy.course.resources.exceptions;

import com.willy.course.services.exceptions.DatabaseException;
import com.willy.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
        String error = "Resource not found";
        int status = HttpStatus.NOT_FOUND.value();
        StandardError standardError = new StandardError(Instant.now(), status, error, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseError(DatabaseException exception, HttpServletRequest request) {
        String error = "Database error";
        int status = HttpStatus.BAD_REQUEST.value();
        StandardError standardError = new StandardError(Instant.now(), status, error, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }
}
