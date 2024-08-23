package demo.quanvan.banking.repository;

import demo.quanvan.banking.entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
}

