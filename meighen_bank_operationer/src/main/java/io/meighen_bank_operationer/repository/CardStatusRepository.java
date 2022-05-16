package io.meighen_bank_operationer.repository;

import java.util.Optional;

import io.meighen_bank_operationer.entity.CardStatus;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardStatusRepository extends JpaRepository<CardStatus, Long> {

    CardStatus findCardStatusByName(String Name);
}
