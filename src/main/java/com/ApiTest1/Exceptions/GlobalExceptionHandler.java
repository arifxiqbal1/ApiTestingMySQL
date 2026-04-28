package com.ApiTest1.Exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;



public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserNotFound(UserNotFoundException us){
        return new ErrorResponse(us.getMessage(), 404);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handleUserNotFound(ProductNotFoundException us){
        return new ErrorResponse(us.getMessage(), 404);
    }
}
