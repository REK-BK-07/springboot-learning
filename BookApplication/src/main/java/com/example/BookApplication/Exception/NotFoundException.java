package com.example.BookApplication.Exception;

public class NotFoundException extends AppException{


    public NotFoundException(String message) {
        super(404,message);
    }
}
