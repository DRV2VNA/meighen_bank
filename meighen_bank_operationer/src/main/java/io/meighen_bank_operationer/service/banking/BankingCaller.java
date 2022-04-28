package io.meighen_bank_operationer.service.banking;

import java.io.IOException;
import java.text.ParseException;

import io.meighen_bank_operationer.entity.Card;
import okhttp3.Response;
import org.springframework.stereotype.Service;

@Service
public class BankingCaller{
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
//    public Pizza orderPizza(String type) {
//        Pizza pizza;
//
//        pizza = factory.createPizza(type);
//
//        pizza.prepare();
//        pizza.bake();
//        pizza.cut();
//        pizza.box();
//
//        return pizza;
//    }
}
