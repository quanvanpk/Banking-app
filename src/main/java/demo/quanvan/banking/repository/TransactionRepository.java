package demo.quanvan.banking.repository;

import demo.quanvan.banking.entity.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

