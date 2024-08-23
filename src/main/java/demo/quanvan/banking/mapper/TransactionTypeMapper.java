package demo.quanvan.banking.mapper;

import demo.quanvan.banking.dto.TransactionTypeDto;
import demo.quanvan.banking.entity.TransactionType;

public class TransactionTypeMapper {

    public static TransactionType mapToTransactionType(TransactionTypeDto transactionTypeDto) {
        return new TransactionType(
                transactionTypeDto.getId(),
                transactionTypeDto.getName()
        );
    }

    public static TransactionTypeDto mapToTransactionTypeDto(TransactionType transactionType) {
        return new TransactionTypeDto(
                transactionType.getId(),
                transactionType.getName()
        );
    }
}

