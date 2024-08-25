package demo.quanvan.banking.service;

import demo.quanvan.banking.dto.JwtResponse;
import demo.quanvan.banking.dto.LoginRequest;
import demo.quanvan.banking.entity.User;

public interface AuthService {
    User registerUser(User user);
    JwtResponse login(LoginRequest loginRequest);
}
