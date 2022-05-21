package io.meighen_bank_presenter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.meighen_bank_presenter.dto.CreateCardDto;
import io.meighen_bank_presenter.dto.DailyTransactionsDto;
import io.meighen_bank_presenter.dto.TransactionDto;
import io.meighen_bank_presenter.repository.RoleRepository;
import io.meighen_bank_presenter.repository.TransactionRepository;
import io.meighen_bank_presenter.repository.UserRepository;
import io.meighen_bank_presenter.service.CardService;
import io.meighen_bank_presenter.service.UserService;
import io.meighen_bank_presenter.service.producer.CardsProducer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserCardsController.class, CardService.class, UserService.class, CardsProducer.class})
@ExtendWith(SpringExtension.class)
class UserCardsControllerTest {
    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    private UserCardsController userCardsController;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link UserCardsController#createCard(CreateCardDto)}
     */
    @Test
    void testCreateCard() throws Exception {
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/cards/create");
        postResult.characterEncoding("Encoding");

        CreateCardDto createCardDto = new CreateCardDto();
        createCardDto.setCardSystem(1);
        createCardDto.setCurrency("GBP");
        String content = (new ObjectMapper()).writeValueAsString(createCardDto);
        MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userCardsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(415));
    }

    /**
     * Method under test: {@link UserCardsController#showDailyTransactions(DailyTransactionsDto)}
     */
    @Test
    void testShowDailyTransactions() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/cards/transaction/daily");
        getResult.characterEncoding("Encoding");

        DailyTransactionsDto dailyTransactionsDto = new DailyTransactionsDto();
        dailyTransactionsDto.setTransactionDate("2020-03-01");
        String content = (new ObjectMapper()).writeValueAsString(dailyTransactionsDto);
        MockHttpServletRequestBuilder requestBuilder = getResult.contentType(MediaType.APPLICATION_JSON).content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userCardsController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(415));
    }
}

