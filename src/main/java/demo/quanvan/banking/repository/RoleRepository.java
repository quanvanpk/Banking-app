package demo.quanvan.banking.repository;

import demo.quanvan.banking.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

