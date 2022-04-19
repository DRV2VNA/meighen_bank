package io.meighen_bank_operationer.service.banking;

import java.io.IOException;
import java.text.ParseException;

import io.meighen_bank_operationer.entity.Card;
import okhttp3.Response;

public interface BankingService {
    public String createCard() throws IOException, ParseException;
}
