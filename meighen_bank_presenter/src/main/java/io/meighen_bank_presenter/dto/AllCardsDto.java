package io.meighen_bank_presenter.dto;

import java.util.List;

import io.meighen_bank_presenter.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllCardsDto {
    List<Card> cards;
}
