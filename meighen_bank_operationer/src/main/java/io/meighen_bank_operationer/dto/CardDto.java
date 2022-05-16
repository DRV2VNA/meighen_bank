package io.meighen_bank_operationer.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CardDto {
    String cardNumber;
    String cvv;
    String expDate;
    String countryCode;
    String type;

    int expYear;
    int expMonth;
    int expDay;
}
