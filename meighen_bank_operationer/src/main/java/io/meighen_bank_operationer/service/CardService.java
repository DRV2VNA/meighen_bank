package io.meighen_bank_operationer.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import io.meighen_bank_operationer.entity.Card;
import io.meighen_bank_operationer.entity.LithicCardDetails;
import io.meighen_bank_operationer.entity.User;
import io.meighen_bank_operationer.repository.CardRepository;
import io.meighen_bank_operationer.repository.LithicCardDetailsRepository;
import io.meighen_bank_operationer.repository.UserRepository;
import io.meighen_bank_operationer.service.banking.BankingCaller;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    BankingCaller bankingCaller;

    @Autowired
    LithicCardDetailsRepository lithicCardDetailsRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    UserRepository userRepository;

    public void createCard(String email) throws IOException, ParseException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> {return new RuntimeException("User with email: " + email + " not found!");});

        String response = bankingCaller.createLithicCard();

        //System.out.println(response);
        JSONObject obj = new JSONObject(response);
        Card card = new Card();
        card.setCard_number(obj.getString("token"));

        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        card.setCreated(df1.parse(obj.getString("created")));
        card.setUpdated(df1.parse(obj.getString("created")));
        card.setCvv(obj.getInt("cvv"));
        //card.setExpDate(new df1.parse(obj.getString("created")));
        card.setExpYear(obj.getInt("exp_year"));
        card.setExpMonth(obj.getInt("exp_month"));
        card.setExpDay(01);
        card.setLastFour(obj.getJSONObject("funding").getString("last_four"));
        card.setCardIssuerName("Lithic");
        card.setLithicCard(true);
        card.setOtherCard(false);

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setHostname(obj.getString("hostname"));
        lithicCardDetails.setSpend_limit(obj.getInt("spend_limit"));
        lithicCardDetails.setSpend_limit_duration(obj.getString("spend_limit_duration"));
        lithicCardDetails.setState(obj.getJSONObject("funding").getString("state"));
        lithicCardDetails.setToken(obj.getJSONObject("funding").getString("token"));
        lithicCardDetails.setType(obj.getJSONObject("funding").getString("type"));
        lithicCardDetails.setNickname(obj.getJSONObject("funding").getString("nickname"));
        lithicCardDetails.setAccount_name(obj.getJSONObject("funding").getString("account_name"));

        card.setLithicCardDetails(lithicCardDetails);

        lithicCardDetailsRepository.save(lithicCardDetails);
        cardRepository.save(card);
        user.getCards().add(card);
        userRepository.save(user);
    }

    public void changeCardStatus(int cardId, String status) throws IOException {
        Card card = cardRepository.findById((long) cardId).orElseThrow(() -> {return new RuntimeException("Card not found!");});
        bankingCaller.changeCardStatus(card, status);
    }

    public void updateCardBalance(Long card_id) {
        Card card = cardRepository.findById(card_id).orElseThrow(() -> {return new RuntimeException("Card not found!");});
        bankingCaller.updateCardBalance(card);
    }
}
