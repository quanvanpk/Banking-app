package demo.quanvan.banking.controller;

import demo.quanvan.banking.entity.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction-types")
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @GetMapping
    public List<TransactionType> getAllTransactionTypes() {
        return transactionTypeService.getAllTransactionTypes();
    }

    @GetMapping("/{id}")
    public TransactionType getTransactionTypeById(@PathVariable Long id) {
        return transactionTypeService.getTransactionTypeById(id);
    }

    @PostMapping
    public TransactionType createTransactionType(@RequestBody TransactionType transactionType) {
        return transactionTypeService.createTransactionType(transactionType);
    }

    @PutMapping("/{id}")
    public TransactionType updateTransactionType(@PathVariable Long id, @RequestBody TransactionType transactionType) {
        return transactionTypeService.updateTransactionType(id, transactionType);
    }

    @DeleteMapping("/{id}")
    public void deleteTransactionType(@PathVariable Long id) {
        transactionTypeService.deleteTransactionType(id);
    }
}

