package demo.quanvan.banking.mapper;

import demo.quanvan.banking.dto.AccountDto;
import demo.quanvan.banking.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(
                accountDto.getId(),
                accountDto.getAccountNumber(),
                UserMapper.mapToUser(accountDto.getUser()),
                AccountTypeMapper.mapToAccountType(accountDto.getAccountType()),
                accountDto.getBalance()
        );
    }

    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getAccountNumber(),
                UserMapper.mapToUserDto(account.getUser()),
                AccountTypeMapper.mapToAccountTypeDto(account.getAccountType()),
                account.getBalance()
        );
    }
}
