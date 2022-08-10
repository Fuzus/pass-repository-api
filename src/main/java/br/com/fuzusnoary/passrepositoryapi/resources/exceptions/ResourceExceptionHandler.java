package br.com.fuzusnoary.passrepositoryapi.resources.exceptions;

import br.com.fuzusnoary.passrepositoryapi.services.exceptions.ObjectNotFoundException;
import br.com.fuzusnoary.passrepositoryapi.services.exceptions.UserNotAllowedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest http) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Not found",
                e.getMessage(),
                http.getRequestURI()
        );
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(UserNotAllowedException.class)
    public ResponseEntity<StandardError> userNotAllowed(UserNotAllowedException e, HttpServletRequest http) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        StandardError err = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Forbidden",
                e.getMessage(),
                http.getRequestURI()
        );
        return ResponseEntity.status(status).body(err);
    }
}
