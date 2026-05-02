package com.example.BookApplication.Service;


import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getWelcomeMessage(String name){
        return "Welcome to DAY 1 of Learning "+name;
    }
}
