package demo.quanvan.banking.service;

import demo.quanvan.banking.entity.TransactionType;
import java.util.List;

public interface TransactionTypeService {

    List<TransactionType> getAllTransactionTypes();

    TransactionType getTransactionTypeById(Long id);

    TransactionType createTransactionType(TransactionType transactionType);

    TransactionType updateTransactionType(Long id, TransactionType transactionType);

    void deleteTransactionType(Long id);
}

