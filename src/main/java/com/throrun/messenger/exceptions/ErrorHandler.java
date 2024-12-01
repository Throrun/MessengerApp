package com.throrun.messenger.exceptions;


import com.throrun.messenger.common.type.MessengerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@AllArgsConstructor
public class ErrorHandler {
    @ExceptionHandler(ProfileNotFoundException.class)
    public ResponseEntity<MessengerResponse<ErrorMessage>> profileNotFound(ProfileNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MessengerResponse.<ErrorMessage>builder().message(exception.getMessage()).build());
    }

    @ExceptionHandler(ProfileAlreadyExistException.class)
    public ResponseEntity<MessengerResponse<ErrorMessage>> profileAlreadyExist(ProfileAlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(MessengerResponse.<ErrorMessage>builder().message(exception.getMessage()).build());
    }

    @ExceptionHandler(WrongCredentialsException.class)
    public ResponseEntity<MessengerResponse<ErrorMessage>> wrongCredentialsException(WrongCredentialsException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(MessengerResponse.<ErrorMessage>builder().message(exception.getMessage()).build());
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<MessengerResponse<ErrorMessage>> tokenExpiredException(TokenExpiredException exception) {
        return ResponseEntity.status(HttpStatus.GONE).body(MessengerResponse.<ErrorMessage>builder().message(exception.getMessage()).build());
    }

    @ExceptionHandler(TokenIsNotValidException.class)
    public ResponseEntity<MessengerResponse<ErrorMessage>> tokenIsNotValidException(TokenIsNotValidException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(MessengerResponse.<ErrorMessage>builder().message(exception.getMessage()).build());
    }

    @ExceptionHandler(TokenNotFoundException.class)
    public ResponseEntity<MessengerResponse<ErrorMessage>> tokenNotFoundException(TokenNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.GONE).body(MessengerResponse.<ErrorMessage>builder().message(exception.getMessage()).build());
    }

}
