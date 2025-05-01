package projetoFinal.Projeto.Final.infra.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import projetoFinal.Projeto.Final.exceptions.AuthenticationException;
import projetoFinal.Projeto.Final.exceptions.UserAlreadyExistsException;
import projetoFinal.Projeto.Final.exceptions.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseMessage> handleUserNotFoundException(UserNotFoundException exception) {
        ErrorResponseMessage errorResponse = new ErrorResponseMessage(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponseMessage> handleAuthenticationException(AuthenticationException exception) {
        ErrorResponseMessage errorResponse = new ErrorResponseMessage(exception.getMessage(), HttpStatus.UNAUTHORIZED.value());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseMessage> handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        ErrorResponseMessage errorResponse = new ErrorResponseMessage(exception.getMessage(), HttpStatus.CONFLICT.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseMessage> handleGenericException(Exception exception) {
        ErrorResponseMessage errorResponse = new ErrorResponseMessage("An unexpected error occurred: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}