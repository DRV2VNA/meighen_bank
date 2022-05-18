package io.meighen_bank_presenter.repository;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import io.meighen_bank_presenter.entity.Transaction;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllBySendFrom(String example);
    List<Transaction> findAllBySendTo(String example);


    List<Transaction> findAllBySendFromAndPerformedBetween(String sendFrom, Date performed, Date performed2);
    List<Transaction> findAllBySendToAndPerformedBetween(String sendTo, Date performed, Date performed2);
}
