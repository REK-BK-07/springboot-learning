package com.example.BookApplication.Controller;

import com.example.BookApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello !! How are you";
    }

    @GetMapping("/greed/{name}")
    public String greedUser(@PathVariable String name){
        return userService.getWelcomeMessage(name);
    }
}