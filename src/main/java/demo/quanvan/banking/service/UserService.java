package demo.quanvan.banking.service;

import demo.quanvan.banking.dto.UserDto;
import demo.quanvan.banking.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    UserDto createUser(User user);

    UserDto updateUser(Long id, User user);

    void deleteUser(Long id);

    Optional<User> findByUsername(String username);
}


