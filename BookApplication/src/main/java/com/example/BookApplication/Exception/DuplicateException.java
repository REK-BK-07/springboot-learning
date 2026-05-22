package com.example.BookApplication.Exception;

public class DuplicateException extends AppException{

    public DuplicateException(String message) {
        super(409,message);
    }
}
