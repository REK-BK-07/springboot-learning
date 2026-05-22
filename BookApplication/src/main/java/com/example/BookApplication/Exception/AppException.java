package com.example.BookApplication.Exception;

public class AppException extends RuntimeException{

    private final Integer statusCode;

    public AppException(Integer statusCode,String message){
        super(message);
        this.statusCode=statusCode;
    }
    public Integer getStatusCode(){
        return statusCode;
    }
}
