package demo.quanvan.banking.mapper;

import demo.quanvan.banking.dto.RoleDto;
import demo.quanvan.banking.entity.Role;

public class RoleMapper {

    public static Role mapToRole(RoleDto roleDto) {
        return new Role(
                roleDto.getId(),
                roleDto.getName()
        );
    }

    public static RoleDto mapToRoleDto(Role role) {
        return new RoleDto(
                role.getId(),
                role.getName()
        );
    }
}

