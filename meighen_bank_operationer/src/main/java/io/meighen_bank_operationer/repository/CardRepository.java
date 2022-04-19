package io.meighen_bank_operationer.repository;

import io.meighen_bank_operationer.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
