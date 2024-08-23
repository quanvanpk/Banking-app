package demo.quanvan.banking.mapper;

import demo.quanvan.banking.dto.AccountTypeDto;
import demo.quanvan.banking.entity.AccountType;

public class AccountTypeMapper {

    public static AccountType mapToAccountType(AccountTypeDto accountTypeDto) {
        return new AccountType(
                accountTypeDto.getId(),
                accountTypeDto.getName()
        );
    }

    public static AccountTypeDto mapToAccountTypeDto(AccountType accountType) {
        return new AccountTypeDto(
                accountType.getId(),
                accountType.getName()
        );
    }
}

