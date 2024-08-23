package demo.quanvan.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private Long id;
    private AccountDto account;
    private TransactionTypeDto transactionType;
    private BigDecimal amount;
    private LocalDateTime date;
}

