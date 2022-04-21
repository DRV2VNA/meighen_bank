package io.meighen_bank_operationer.service.consumer;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.meighen_bank_operationer.model.KafkaMsg;
import io.meighen_bank_operationer.service.CardService;
import io.meighen_bank_operationer.service.banking.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CardsConsumerService {
    @Autowired
    CardService cardService;

    @KafkaListener(topics = "leaj4m20-banking-main", groupId = "creating_card")
    public void consume(KafkaMsg message) throws IOException, ParseException {
        System.out.println("Consuming the message: " + message);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(message.getBody(), Map.class);
        callOperation(map);
    }

    private void callOperation(Map<String, String> message) throws IOException, ParseException {
        String operation = message.get("operation");
        if (Objects.equals(operation, "create_card")) {
            cardService.createCard(message.get("email"));
        } if (Objects.equals(operation, "change_card_status")) {
            cardService.changeCardStatus(Integer.parseInt(message.get("card_id")), message.get("status"));
        } else {
            System.out.println("Error! Not correct message. Reason: no operation known! " + message);
        }
    }
}
