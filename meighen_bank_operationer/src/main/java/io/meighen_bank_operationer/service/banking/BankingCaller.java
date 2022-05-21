package io.meighen_bank_operationer.service.banking;

import java.io.IOException;
import java.text.ParseException;

import io.meighen_bank_operationer.entity.Card;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankingCaller{
    @Autowired
    BankingFactory factory;

    public BankingCaller() {
        this.factory = new BankingFactory();
    }

    public String createLithicCard() throws IOException, ParseException {
        return factory.createLithicService().createCard();
    }

    public void changeCardStatus(Card card, String status) throws IOException {
        factory.createBankingService(card).changeCardState(card, status);
    }

    public void updateCardBalance(Card card) throws IOException {
        factory.createBankingService(card).getCardsDetail(card.getLithicCardDetails().getToken());
    }

    public String createVisaCard() throws IOException, ParseException {
        return factory.createInternalServiceVisa().createCard();
    }

    public String createMastercardCard() throws IOException, ParseException {
        return factory.createInternalServiceMastercard().createCard();
    }

    public boolean subtractMoney(Card card, Double ammount) {
        return factory.createBankingService(card).subtractMoney(card, ammount);
    }

    public boolean addMoney(Card card, Double ammount) {
        return factory.createBankingService(card).getMoney(card, ammount);
    }
}
