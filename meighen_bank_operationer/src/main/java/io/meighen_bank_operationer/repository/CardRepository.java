package io.meighen_bank_operationer.repository;

import java.util.Optional;

import io.meighen_bank_operationer.entity.Card;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, Long> {
    @Query("select c from Card c where c.card_number = ?1")
    Optional<Card> findCardByCard_number(String card_num);
}
