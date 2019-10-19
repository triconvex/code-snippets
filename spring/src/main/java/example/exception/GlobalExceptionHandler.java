package example.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=RuntimeException.class)
    public void defaultExceptionHandler(Exception exception) {
        log.debug("exception detected!! <{} : {}>", exception.getClass(), exception.getMessage());
    }

    @ExceptionHandler(value= HttpMediaTypeNotSupportedException.class)
    public void httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException exception) {
        log.debug("exception detected!! <{} : {}>", exception.getClass(), exception.getMessage());
    }

}
