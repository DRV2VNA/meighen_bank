package io.meighen_bank_presenter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.meighen_bank_presenter.dto.CreateCardDto;
import io.meighen_bank_presenter.entity.User;
import io.meighen_bank_presenter.model.CreateCardModel;
import io.meighen_bank_presenter.model.KafkaMsg;
import io.meighen_bank_presenter.service.producer.CardsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    private CardsProducer cardsProducer;

    public void createCard(CreateCardDto createCardDto, User user) throws JsonProcessingException {
        CreateCardModel createCardModel = new CreateCardModel();
        createCardModel.setOperation("create_card");
        createCardModel.setEmail(user.getEmail());
        createCardModel.setCurrency(createCardDto.getCurrency());
        createCardModel.setCardSystem(createCardDto.getCardSystem());

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(createCardModel);
        System.out.println(json);
        cardsProducer.createCard(json);
    }
}
