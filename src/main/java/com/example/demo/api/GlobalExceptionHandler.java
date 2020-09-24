package com.example.demo.api;

import com.example.demo.dto.CustomError;
import com.example.demo.exception.UserNotFoundException;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public CustomError handle(UserNotFoundException ex) {
        return new CustomError(ex.getMessage(), new Date(), HttpStatus.NOT_FOUND);
    }
}
