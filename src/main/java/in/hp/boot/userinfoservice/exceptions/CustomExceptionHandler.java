package in.hp.boot.userinfoservice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Slf4j
@RestController
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        GenericException genericException = new GenericException(
                new Date().toString(), ex.getMessage(), request.getDescription(false));
        log.error("Exception handleAllException: [{}]", genericException);
        return new ResponseEntity<>(genericException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object> handleAllException(ResourceNotFoundException ex, WebRequest request) {
        GenericException genericException = new GenericException(
                new Date().toString(), ex.getMessage(), request.getDescription(false));
//        return new ResponseEntity<>(genericException, HttpStatus.NOT_FOUND);
        log.error("Exception ResourceNotFoundException: [{}]", genericException);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(genericException);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        GenericException genericException = new GenericException(
                new Date().toString(), "Validation failed for input.", ex.getBindingResult().toString()
        );
        log.error("Exception handleMethodArgumentNotValid: [{}]", genericException);
        return new ResponseEntity<>(genericException, status);
    }
}
