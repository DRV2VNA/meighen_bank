package io.meighen_bank_operationer.service.banking;

import java.io.IOException;
import java.text.ParseException;

import io.meighen_bank_operationer.entity.Card;
import okhttp3.Response;
import org.springframework.stereotype.Service;

@Service
public interface BankingService {
    public String createCard() throws IOException, ParseException;
    public void changeCardState(Card card, String state) throws IOException;
    public String getCardsDetail(String cardToken) throws IOException;
}
