package demo.quanvan.banking.service.impl;

import demo.quanvan.banking.entity.TransactionType;
import demo.quanvan.banking.repository.TransactionTypeRepository;
import demo.quanvan.banking.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {
    private final TransactionTypeRepository transactionTypeRepository;

    @Autowired
    public TransactionTypeServiceImpl(TransactionTypeRepository transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }

    @Override
    public List<TransactionType> getAllTransactionTypes() {
        return transactionTypeRepository.findAll();
    }

    @Override
    public TransactionType getTransactionTypeById(Long id) {
        return transactionTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction Type not found"));
    }

    @Override
    public TransactionType createTransactionType(TransactionType transactionType) {
        return transactionTypeRepository.save(transactionType);
    }

    @Override
    public TransactionType updateTransactionType(Long id, TransactionType transactionType) {
        if (!transactionTypeRepository.existsById(id)) {
            throw new RuntimeException("Transaction Type not found");
        }
        transactionType.setId(id);
        return transactionTypeRepository.save(transactionType);
    }

    @Override
    public void deleteTransactionType(Long id) {
        if (!transactionTypeRepository.existsById(id)) {
            throw new RuntimeException("Transaction Type not found");
        }
        transactionTypeRepository.deleteById(id);
    }
}

