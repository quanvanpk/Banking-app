package demo.quanvan.banking.service.impl;

import demo.quanvan.banking.config.JwtUtil;
import demo.quanvan.banking.dto.JwtResponse;
import demo.quanvan.banking.dto.LoginRequest;
import demo.quanvan.banking.entity.Role;
import demo.quanvan.banking.entity.User;
import demo.quanvan.banking.repository.RoleRepository;
import demo.quanvan.banking.repository.UserRepository;
import demo.quanvan.banking.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        Role role = roleRepository.findById(user.getRole().getId())
                .orElseThrow(() -> new RuntimeException("Role does not exist"));
        user.setRole(role);

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByUsername(loginRequest.getUsername());

        if (optionalUser.isPresent() && passwordEncoder.matches(loginRequest.getPassword(), optionalUser.get().getPassword())) {
            String token = jwtUtil.generateToken(loginRequest.getUsername());
            return new JwtResponse(optionalUser.get().getUsername(), token);
        }

        throw new RuntimeException("Invalid username or password");
    }
}

