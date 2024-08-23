package demo.quanvan.banking.service;

import demo.quanvan.banking.entity.AccountType;
import java.util.List;

public interface AccountTypeService {

    List<AccountType> getAllAccountTypes();

    AccountType getAccountTypeById(Long id);

    AccountType createAccountType(AccountType accountType);

    AccountType updateAccountType(Long id, AccountType accountType);

    void deleteAccountType(Long id);
}