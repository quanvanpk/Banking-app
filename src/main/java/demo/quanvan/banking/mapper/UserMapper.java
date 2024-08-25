package demo.quanvan.banking.mapper;

import demo.quanvan.banking.dto.UserDto;
import demo.quanvan.banking.entity.User;

public class UserMapper {

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                null,
                userDto.getEmail(),
                RoleMapper.mapToRole(userDto.getRole())
        );
    }

    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                RoleMapper.mapToRoleDto(user.getRole())
        );
    }
}
