package io.meighen_bank_operationer.repository;

import io.meighen_bank_operationer.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
