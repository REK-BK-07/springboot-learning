package com.example.BookApplication.Exception;

public class BadRequestException extends AppException{

    public BadRequestException(String message) {

        super(400, message);
    }
}
