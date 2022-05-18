package io.meighen_bank_presenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    String cardFrom;
    String cardTo;
    String ammount;

    String cardFromCVV;
    String cardFromExpDate;

    String tType;
}
