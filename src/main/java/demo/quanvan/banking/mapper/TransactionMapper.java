package demo.quanvan.banking.mapper;

import demo.quanvan.banking.dto.TransactionDto;
import demo.quanvan.banking.entity.Transaction;

public class TransactionMapper {

    public static Transaction mapToTransaction(TransactionDto transactionDto) {
        return new Transaction(
                transactionDto.getId(),
                AccountMapper.mapToAccount(transactionDto.getAccount()),
                TransactionTypeMapper.mapToTransactionType(transactionDto.getTransactionType()),
                transactionDto.getAmount(),
                transactionDto.getDate()
        );
    }

    public static TransactionDto mapToTransactionDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                AccountMapper.mapToAccountDto(transaction.getAccount()),
                TransactionTypeMapper.mapToTransactionTypeDto(transaction.getTransactionType()),
                transaction.getAmount(),
                transaction.getDate()
        );
    }
}
