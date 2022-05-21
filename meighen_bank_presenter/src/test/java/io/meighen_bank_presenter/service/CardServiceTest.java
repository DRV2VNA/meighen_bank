package io.meighen_bank_presenter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.meighen_bank_presenter.dto.CreateCardDto;
import io.meighen_bank_presenter.dto.TransactionDto;
import io.meighen_bank_presenter.entity.Role;
import io.meighen_bank_presenter.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CardServiceTest {
    @Autowired
    private CardService cardService;

    /**
     * Method under test: {@link CardService#createCard(CreateCardDto, User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCard() throws JsonProcessingException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access JMX APIs.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        CreateCardDto createCardDto = new CreateCardDto(1, "GBP");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        this.cardService.createCard(createCardDto, user);
    }

    /**
     * Method under test: {@link CardService#createCard(CreateCardDto, User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCard2() throws JsonProcessingException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access JMX APIs.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        CreateCardDto createCardDto = new CreateCardDto(2, "GBP");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        this.cardService.createCard(createCardDto, user);
    }

    /**
     * Method under test: {@link CardService#createCard(CreateCardDto, User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCard3() throws JsonProcessingException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access JMX APIs.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        CreateCardDto createCardDto = new CreateCardDto(1,
                "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"%s\" password=\"%s\";");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        this.cardService.createCard(createCardDto, user);
    }

    /**
     * Method under test: {@link CardService#createCard(CreateCardDto, User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCard4() throws JsonProcessingException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at io.meighen_bank_presenter.service.CardService.createCard(CardService.java:26)
        //   In order to prevent createCard(CreateCardDto, User)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createCard(CreateCardDto, User).
        //   See https://diff.blue/R013 to resolve this issue.

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        this.cardService.createCard(null, user);
    }

    /**
     * Method under test: {@link CardService#doIntCardTransaction(TransactionDto, User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoIntCardTransaction() throws JsonProcessingException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access JMX APIs.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        TransactionDto transactionDto = new TransactionDto("jane.doe@example.org", "alice.liddell@example.org", "Ammount",
                "jane.doe@example.org", "2020-03-01", "T Type");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        this.cardService.doIntCardTransaction(transactionDto, user);
    }

    /**
     * Method under test: {@link CardService#doIntCardTransaction(TransactionDto, User)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDoIntCardTransaction2() throws JsonProcessingException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access JMX APIs.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        TransactionDto transactionDto = new TransactionDto(
                "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"%s\" password=\"%s\";",
                "alice.liddell@example.org", "Ammount", "jane.doe@example.org", "2020-03-01", "T Type");

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        User user = new User();
        user.setActivationCode("Activation Code");
        user.setCards(new ArrayList<>());
        user.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setRole(role);
        user.setSecondName("Second Name");
        user.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user.setUserProfileImageUrl("https://example.org/example");
        user.setUserTransactions(new ArrayList<>());
        user.setUsername("janedoe");
        this.cardService.doIntCardTransaction(transactionDto, user);
    }
}

