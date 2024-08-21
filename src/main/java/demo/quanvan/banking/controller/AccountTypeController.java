package demo.quanvan.banking.controller;

import demo.quanvan.banking.entity.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account-types")
public class AccountTypeController {

    @Autowired
    private AccountTypeService accountTypeService;

    @GetMapping
    public List<AccountType> getAllAccountTypes() {
        return accountTypeService.getAllAccountTypes();
    }

    @GetMapping("/{id}")
    public AccountType getAccountTypeById(@PathVariable Long id) {
        return accountTypeService.getAccountTypeById(id);
    }

    @PostMapping
    public AccountType createAccountType(@RequestBody AccountType accountType) {
        return accountTypeService.createAccountType(accountType);
    }

    @PutMapping("/{id}")
    public AccountType updateAccountType(@PathVariable Long id, @RequestBody AccountType accountType) {
        return accountTypeService.updateAccountType(id, accountType);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountType(@PathVariable Long id) {
        accountTypeService.deleteAccountType(id);
    }
}
