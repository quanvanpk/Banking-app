package demo.quanvan.banking.controller;

import demo.quanvan.banking.dto.JwtResponse;
import demo.quanvan.banking.dto.LoginRequest;
import demo.quanvan.banking.entity.User;
import demo.quanvan.banking.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return authService.registerUser(user);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
