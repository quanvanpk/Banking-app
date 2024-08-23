package demo.quanvan.banking.service.impl;

import demo.quanvan.banking.entity.AccountType;
import demo.quanvan.banking.repository.AccountTypeRepository;
import demo.quanvan.banking.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeServiceImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountType> getAllAccountTypes() {
        return accountTypeRepository.findAll();
    }

    @Override
    public AccountType getAccountTypeById(Long id) {
        return accountTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account type not found"));
    }

    @Override
    public AccountType createAccountType(AccountType accountType) {
        return accountTypeRepository.save(accountType);
    }

    @Override
    public AccountType updateAccountType(Long id, AccountType accountType) {
        if (!accountTypeRepository.existsById(id)) {
            throw new RuntimeException("Account type not found");
        }
        accountType.setId(id);
        return accountTypeRepository.save(accountType);
    }

    @Override
    public void deleteAccountType(Long id) {
        if (!accountTypeRepository.existsById(id)) {
            throw new RuntimeException("Account type not found");
        }
        accountTypeRepository.deleteById(id);
    }
}

