package com.example.BookApplication.Controller;


import com.example.BookApplication.Dto.LoginDto;
import com.example.BookApplication.Model.User;
import com.example.BookApplication.Repository.UserRepository;
import com.example.BookApplication.Security.JwtFilter;
import com.example.BookApplication.Security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "USER REGISTERED SUCCESSFULLY";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        User user=userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow();

        return jwtUtils.generateToken(user.getEmail(),user.getRole());
    }
}
