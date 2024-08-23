package demo.quanvan.banking.service;

import demo.quanvan.banking.entity.Role;
import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRoleById(Long id);

    Role createRole(Role role);

    Role updateRole(Long id, Role role);

    void deleteRole(Long id);
}


