package io.meighen_bank_operationer.service.banking;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.meighen_bank_operationer.dto.CardDto;
import io.meighen_bank_operationer.entity.Card;
import io.meighen_bank_operationer.entity.OtherCardDetail;
import io.meighen_bank_operationer.repository.CardRepository;
import io.meighen_bank_operationer.repository.CardStatusRepository;
import io.meighen_bank_operationer.repository.OtherCardDetailsRepository;
import net.andreinc.mockneat.MockNeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static net.andreinc.mockneat.types.enums.CreditCardType.MASTERCARD;
import static net.andreinc.mockneat.types.enums.CreditCardType.VISA_16;

@Service
public class InternalBankingMastercard implements BankingService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    OtherCardDetailsRepository otherCardDetailsRepository;

    @Autowired
    CardStatusRepository cardStatusRepository;

    public String createCard() throws IOException, ParseException {
        MockNeat m = MockNeat.threadLocal();
        String visa16 = m.creditCards().type(MASTERCARD).get();
        String cvv = m.cvvs().get();

        CardDto cardDto = new CardDto();
        cardDto.setCardNumber(visa16);
        cardDto.setCvv(cvv);
        cardDto.setCountryCode("RU");
        LocalDate date = LocalDate.now();
        date = date.plusYears(3);

        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date d = df1.getCalendar().getTime();

        cardDto.setExpDate(d.toString());
        cardDto.setExpYear(d.getYear()+2000);
        cardDto.setExpMonth(d.getMonth());
        cardDto.setExpDay(d.getDay());

        cardDto.setType("internal_mastercard");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(cardDto);

        return json;
    }

    public void changeCardState(Card card, String state) throws IOException {
        if (!(state.equals("CLOSED") || state.equals("OPEN") || state.equals("PAUSED"))) {return;}

        Card c = cardRepository.findCardByCard_number(card.getCard_number()).get();
        OtherCardDetail otherCardDetails = card.getOtherCardDetail();

        if (state.equals("CLOSED")) {
            otherCardDetails.setLive(false);
            card.setCardStatus(cardStatusRepository.findCardStatusByName("CLOSED"));
        } else if (state.equals("OPEN")) {
            otherCardDetails.setLive(true);
            card.setCardStatus(cardStatusRepository.findCardStatusByName("OPEN"));
        }else if (state.equals("PAUSED")) {
            otherCardDetails.setLive(true);
            card.setCardStatus(cardStatusRepository.findCardStatusByName("PAUSED"));
        }

    }

    public String getCardsDetail(String cardToken) throws IOException {

        return null;
    }

    public boolean subtractMoney(Card card, Double ammount) {
        if (card.getBalance() > ammount) {
            card.setBalance(card.getBalance() - ammount);
            cardRepository.save(card);
            return true;
        } else {
            return false;
        }
    }

    public boolean getMoney(Card card, Double ammount){
        card.setBalance(card.getBalance() + ammount);
        cardRepository.save(card);

        return true;
    }
}
