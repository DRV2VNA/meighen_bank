package io.meighen_bank_operationer.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.meighen_bank_operationer.entity.Card;
import io.meighen_bank_operationer.entity.CardStatus;
import io.meighen_bank_operationer.entity.LithicCardDetails;
import io.meighen_bank_operationer.entity.OtherCardDetail;
import io.meighen_bank_operationer.entity.Role;
import io.meighen_bank_operationer.entity.Transaction;
import io.meighen_bank_operationer.entity.User;
import io.meighen_bank_operationer.repository.CardRepository;
import io.meighen_bank_operationer.repository.CardStatusRepository;
import io.meighen_bank_operationer.repository.LithicCardDetailsRepository;
import io.meighen_bank_operationer.repository.OtherCardDetailsRepository;
import io.meighen_bank_operationer.repository.TransactionRepository;
import io.meighen_bank_operationer.repository.UserRepository;
import io.meighen_bank_operationer.service.banking.BankingCaller;
import io.meighen_bank_operationer.service.banking.BankingFactory;
import io.meighen_bank_operationer.service.banking.InternalBankingMastercard;
import io.meighen_bank_operationer.service.banking.InternalBankingVisa;
import io.meighen_bank_operationer.service.banking.LithicBanking;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CardServiceTest {
    @MockBean
    private CardStatusRepository cardStatusRepository;

    @MockBean
    private CardRepository cardRepository;

    @Autowired
    private CardService cardService;

    @MockBean
    private LithicCardDetailsRepository lithicCardDetailsRepository;

    @MockBean
    private OtherCardDetailsRepository otherCardDetailsRepository;

    @MockBean
    private TransactionRepository transactionRepository;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link CardService#createCard(String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCard() throws IOException, ParseException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Card System Str"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Integer.parseInt(Integer.java:652)
        //       at java.lang.Integer.valueOf(Integer.java:983)
        //       at io.meighen_bank_operationer.service.CardService.createCard(CardService.java:39)
        //   In order to prevent createCard(String, String, String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createCard(String, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Card System Str"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Integer.parseInt(Integer.java:652)
        //       at java.lang.Integer.valueOf(Integer.java:983)
        //       at io.meighen_bank_operationer.service.CardService.createCard(CardService.java:39)
        //   In order to prevent createCard(String, String, String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createCard(String, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new CardService()).createCard("jane.doe@example.org", "Card System Str", "GBP");
    }

    /**
     * Method under test: {@link CardService#createCard(String, String, String)}
     */
    @Test
    void testCreateCard2() throws IOException, ParseException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "Card System Str"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Integer.parseInt(Integer.java:652)
        //       at java.lang.Integer.valueOf(Integer.java:983)
        //       at io.meighen_bank_operationer.service.CardService.createCard(CardService.java:39)
        //   In order to prevent createCard(String, String, String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createCard(String, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        CardService cardService = new CardService();
        cardService.createCard("jane.doe@example.org", "00", "GBP");
        assertNull(cardService.bankingCaller);
        assertNull(cardService.userRepository);
        assertNull(cardService.transactionRepository);
        assertNull(cardService.otherCardDetailsRepository);
        assertNull(cardService.lithicCardDetailsRepository);
        assertNull(cardService.cardRepository);
    }

    /**
     * Method under test: {@link CardService#createMastercardCard(String, String)}
     */
    @Test
    void testCreateMastercardCard() throws IOException, ParseException {
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
        Optional<User> ofResult = Optional.of(user);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setActivationCode("Activation Code");
        user1.setCards(new ArrayList<>());
        user1.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("4105551212");
        user1.setRole(role1);
        user1.setSecondName("Second Name");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setUserTransactions(new ArrayList<>());
        user1.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");
        when(this.otherCardDetailsRepository.save((OtherCardDetail) any())).thenReturn(otherCardDetail);

        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail1 = new OtherCardDetail();
        otherCardDetail1.setAccountId("42");
        otherCardDetail1.setCountryCode("GB");
        otherCardDetail1.setFirstNumbers("42");
        otherCardDetail1.setId(123L);
        otherCardDetail1.setLive(true);
        otherCardDetail1.setProgramId("42");
        otherCardDetail1.setScheme("Scheme");
        otherCardDetail1.setType("Type");

        Card card = new Card();
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(1);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(true);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail1);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        when(this.cardRepository.save((Card) any())).thenReturn(card);
        this.cardService.createMastercardCard("jane.doe@example.org", "GBP");
        verify(this.userRepository).save((User) any());
        verify(this.userRepository).findByEmail((String) any());
        verify(this.otherCardDetailsRepository).save((OtherCardDetail) any());
        verify(this.cardRepository).save((Card) any());
    }

    /**
     * Method under test: {@link CardService#createMastercardCard(String, String)}
     */
    @Test
    void testCreateMastercardCard2() throws IOException, ParseException {
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
        Optional<User> ofResult = Optional.of(user);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setActivationCode("Activation Code");
        user1.setCards(new ArrayList<>());
        user1.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("4105551212");
        user1.setRole(role1);
        user1.setSecondName("Second Name");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setUserTransactions(new ArrayList<>());
        user1.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");
        when(this.otherCardDetailsRepository.save((OtherCardDetail) any())).thenReturn(otherCardDetail);
        when(this.cardRepository.save((Card) any())).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.cardService.createMastercardCard("jane.doe@example.org", "GBP"));
        verify(this.userRepository).findByEmail((String) any());
        verify(this.otherCardDetailsRepository).save((OtherCardDetail) any());
        verify(this.cardRepository).save((Card) any());
    }

    /**
     * Method under test: {@link CardService#createVisaCard(String, String)}
     */
    @Test
    void testCreateVisaCard() throws IOException, ParseException {
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
        Optional<User> ofResult = Optional.of(user);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setActivationCode("Activation Code");
        user1.setCards(new ArrayList<>());
        user1.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("4105551212");
        user1.setRole(role1);
        user1.setSecondName("Second Name");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setUserTransactions(new ArrayList<>());
        user1.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");
        when(this.otherCardDetailsRepository.save((OtherCardDetail) any())).thenReturn(otherCardDetail);

        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail1 = new OtherCardDetail();
        otherCardDetail1.setAccountId("42");
        otherCardDetail1.setCountryCode("GB");
        otherCardDetail1.setFirstNumbers("42");
        otherCardDetail1.setId(123L);
        otherCardDetail1.setLive(true);
        otherCardDetail1.setProgramId("42");
        otherCardDetail1.setScheme("Scheme");
        otherCardDetail1.setType("Type");

        Card card = new Card();
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(1);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(true);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail1);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        when(this.cardRepository.save((Card) any())).thenReturn(card);
        this.cardService.createVisaCard("jane.doe@example.org", "GBP");
        verify(this.userRepository).save((User) any());
        verify(this.userRepository).findByEmail((String) any());
        verify(this.otherCardDetailsRepository).save((OtherCardDetail) any());
        verify(this.cardRepository).save((Card) any());
    }

    /**
     * Method under test: {@link CardService#createVisaCard(String, String)}
     */
    @Test
    void testCreateVisaCard2() throws IOException, ParseException {
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
        Optional<User> ofResult = Optional.of(user);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");

        User user1 = new User();
        user1.setActivationCode("Activation Code");
        user1.setCards(new ArrayList<>());
        user1.setCreatedActivationCode("Jan 1, 2020 8:00am GMT+0100");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setPhoneNumber("4105551212");
        user1.setRole(role1);
        user1.setSecondName("Second Name");
        user1.setTimeOfAccountCreation(LocalDateTime.of(1, 1, 1, 1, 1));
        user1.setUserProfileImageUrl("https://example.org/example");
        user1.setUserTransactions(new ArrayList<>());
        user1.setUsername("janedoe");
        when(this.userRepository.save((User) any())).thenReturn(user1);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");
        when(this.otherCardDetailsRepository.save((OtherCardDetail) any())).thenReturn(otherCardDetail);
        when(this.cardRepository.save((Card) any())).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> this.cardService.createVisaCard("jane.doe@example.org", "GBP"));
        verify(this.userRepository).findByEmail((String) any());
        verify(this.otherCardDetailsRepository).save((OtherCardDetail) any());
        verify(this.cardRepository).save((Card) any());
    }

    /**
     * Method under test: {@link CardService#createLithicCard(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateLithicCard() throws IOException, ParseException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);
        this.cardService.createLithicCard("jane.doe@example.org");
    }

    /**
     * Method under test: {@link CardService#createLithicCard(String)}
     */
    @Test
    void testCreateLithicCard2() throws IOException, ParseException {
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> this.cardService.createLithicCard("jane.doe@example.org"));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link CardService#changeCardStatus(int, String)}
     */
    @Test
    void testChangeCardStatus() throws IOException {
        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");

        Card card = new Card();
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(1);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(true);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        Optional<Card> ofResult = Optional.of(card);
        when(this.cardRepository.findById((Long) any())).thenReturn(ofResult);
        this.cardService.changeCardStatus(123, "Status");
        verify(this.cardRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link CardService#changeCardStatus(int, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeCardStatus2() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at io.meighen_bank_operationer.service.banking.BankingCaller.changeCardStatus(BankingCaller.java:25)
        //       at io.meighen_bank_operationer.service.CardService.changeCardStatus(CardService.java:176)
        //   In order to prevent changeCardStatus(int, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeCardStatus(int, String).
        //   See https://diff.blue/R013 to resolve this issue.

        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");

        Card card = new Card();
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(1);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(false);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        Optional<Card> ofResult = Optional.of(card);
        when(this.cardRepository.findById((Long) any())).thenReturn(ofResult);
        this.cardService.changeCardStatus(123, "Status");
    }

    /**
     * Method under test: {@link CardService#updateCardBalance(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCardBalance() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");

        Card card = new Card();
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(1);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(true);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        Optional<Card> ofResult = Optional.of(card);
        when(this.cardRepository.findById((Long) any())).thenReturn(ofResult);
        this.cardService.updateCardBalance(1L);
    }

    /**
     * Method under test: {@link CardService#updateCardBalance(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCardBalance2() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at io.meighen_bank_operationer.service.banking.BankingCaller.updateCardBalance(BankingCaller.java:29)
        //       at io.meighen_bank_operationer.service.CardService.updateCardBalance(CardService.java:181)
        //   In order to prevent updateCardBalance(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateCardBalance(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");

        LithicCardDetails lithicCardDetails1 = new LithicCardDetails();
        lithicCardDetails1.setAccount_name("Dr Jane Doe");
        lithicCardDetails1.setHostname("localhost");
        lithicCardDetails1.setId(123L);
        lithicCardDetails1.setNickname("Nickname");
        lithicCardDetails1.setSpend_limit(3);
        lithicCardDetails1.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails1.setState("MD");
        lithicCardDetails1.setToken("ABC123");
        lithicCardDetails1.setType("Type");
        Card card = mock(Card.class);
        when(card.getCardIssuerName()).thenReturn("Card Issuer Name");
        when(card.isLithicCard()).thenReturn(false);
        when(card.isOtherCard()).thenReturn(true);
        when(card.getLithicCardDetails()).thenReturn(lithicCardDetails1);
        doNothing().when(card).setId(anyLong());
        doNothing().when(card).setBalance(anyDouble());
        doNothing().when(card).setCardIssuerName((String) any());
        doNothing().when(card).setCardStatus((CardStatus) any());
        doNothing().when(card).setCard_number((String) any());
        doNothing().when(card).setCreated((Date) any());
        doNothing().when(card).setCvv(anyInt());
        doNothing().when(card).setExpDate((Date) any());
        doNothing().when(card).setExpDay(anyInt());
        doNothing().when(card).setExpMonth(anyInt());
        doNothing().when(card).setExpYear(anyInt());
        doNothing().when(card).setLastFour((String) any());
        doNothing().when(card).setLithicCard(anyBoolean());
        doNothing().when(card).setLithicCardDetails((LithicCardDetails) any());
        doNothing().when(card).setOtherCard(anyBoolean());
        doNothing().when(card).setOtherCardDetail((OtherCardDetail) any());
        doNothing().when(card).setUpdated((Date) any());
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(1);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(true);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        Optional<Card> ofResult = Optional.of(card);
        when(this.cardRepository.findById((Long) any())).thenReturn(ofResult);
        this.cardService.updateCardBalance(1L);
    }

    /**
     * Method under test: {@link CardService#updateCardBalance(Long)}
     */
    @Test
    void testUpdateCardBalance3() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        when(this.cardRepository.findById((Long) any())).thenReturn(Optional.empty());

        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");

        LithicCardDetails lithicCardDetails1 = new LithicCardDetails();
        lithicCardDetails1.setAccount_name("Dr Jane Doe");
        lithicCardDetails1.setHostname("localhost");
        lithicCardDetails1.setId(123L);
        lithicCardDetails1.setNickname("Nickname");
        lithicCardDetails1.setSpend_limit(3);
        lithicCardDetails1.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails1.setState("MD");
        lithicCardDetails1.setToken("ABC123");
        lithicCardDetails1.setType("Type");
        Card card = mock(Card.class);
        when(card.getCardIssuerName()).thenReturn("Card Issuer Name");
        when(card.isLithicCard()).thenReturn(false);
        when(card.isOtherCard()).thenReturn(true);
        when(card.getLithicCardDetails()).thenReturn(lithicCardDetails1);
        doNothing().when(card).setId(anyLong());
        doNothing().when(card).setBalance(anyDouble());
        doNothing().when(card).setCardIssuerName((String) any());
        doNothing().when(card).setCardStatus((CardStatus) any());
        doNothing().when(card).setCard_number((String) any());
        doNothing().when(card).setCreated((Date) any());
        doNothing().when(card).setCvv(anyInt());
        doNothing().when(card).setExpDate((Date) any());
        doNothing().when(card).setExpDay(anyInt());
        doNothing().when(card).setExpMonth(anyInt());
        doNothing().when(card).setExpYear(anyInt());
        doNothing().when(card).setLastFour((String) any());
        doNothing().when(card).setLithicCard(anyBoolean());
        doNothing().when(card).setLithicCardDetails((LithicCardDetails) any());
        doNothing().when(card).setOtherCard(anyBoolean());
        doNothing().when(card).setOtherCardDetail((OtherCardDetail) any());
        doNothing().when(card).setUpdated((Date) any());
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(1);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(true);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        assertThrows(RuntimeException.class, () -> this.cardService.updateCardBalance(1L));
        verify(this.cardRepository).findById((Long) any());
        verify(card).setId(anyLong());
        verify(card).setBalance(anyDouble());
        verify(card).setCardIssuerName((String) any());
        verify(card).setCardStatus((CardStatus) any());
        verify(card).setCard_number((String) any());
        verify(card).setCreated((Date) any());
        verify(card).setCvv(anyInt());
        verify(card).setExpDate((Date) any());
        verify(card).setExpDay(anyInt());
        verify(card).setExpMonth(anyInt());
        verify(card).setExpYear(anyInt());
        verify(card).setLastFour((String) any());
        verify(card).setLithicCard(anyBoolean());
        verify(card).setLithicCardDetails((LithicCardDetails) any());
        verify(card).setOtherCard(anyBoolean());
        verify(card).setOtherCardDetail((OtherCardDetail) any());
        verify(card).setUpdated((Date) any());
    }

    /**
     * Method under test: {@link CardService#updateCardBalance(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCardBalance4() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException: An error occurred
        //       at io.meighen_bank_operationer.service.banking.BankingFactory.createBankingService(BankingFactory.java:24)
        //       at io.meighen_bank_operationer.service.banking.BankingCaller.updateCardBalance(BankingCaller.java:29)
        //       at io.meighen_bank_operationer.service.CardService.updateCardBalance(CardService.java:181)
        //   In order to prevent updateCardBalance(Long)
        //   from throwing RuntimeException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateCardBalance(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");

        LithicCardDetails lithicCardDetails1 = new LithicCardDetails();
        lithicCardDetails1.setAccount_name("Dr Jane Doe");
        lithicCardDetails1.setHostname("localhost");
        lithicCardDetails1.setId(123L);
        lithicCardDetails1.setNickname("Nickname");
        lithicCardDetails1.setSpend_limit(3);
        lithicCardDetails1.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails1.setState("MD");
        lithicCardDetails1.setToken("ABC123");
        lithicCardDetails1.setType("Type");
        Card card = mock(Card.class);
        when(card.getCardIssuerName()).thenThrow(new RuntimeException("An error occurred"));
        when(card.isLithicCard()).thenReturn(false);
        when(card.isOtherCard()).thenReturn(true);
        when(card.getLithicCardDetails()).thenReturn(lithicCardDetails1);
        doNothing().when(card).setId(anyLong());
        doNothing().when(card).setBalance(anyDouble());
        doNothing().when(card).setCardIssuerName((String) any());
        doNothing().when(card).setCardStatus((CardStatus) any());
        doNothing().when(card).setCard_number((String) any());
        doNothing().when(card).setCreated((Date) any());
        doNothing().when(card).setCvv(anyInt());
        doNothing().when(card).setExpDate((Date) any());
        doNothing().when(card).setExpDay(anyInt());
        doNothing().when(card).setExpMonth(anyInt());
        doNothing().when(card).setExpYear(anyInt());
        doNothing().when(card).setLastFour((String) any());
        doNothing().when(card).setLithicCard(anyBoolean());
        doNothing().when(card).setLithicCardDetails((LithicCardDetails) any());
        doNothing().when(card).setOtherCard(anyBoolean());
        doNothing().when(card).setOtherCardDetail((OtherCardDetail) any());
        doNothing().when(card).setUpdated((Date) any());
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(1);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(true);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        Optional<Card> ofResult = Optional.of(card);
        when(this.cardRepository.findById((Long) any())).thenReturn(ofResult);
        this.cardService.updateCardBalance(1L);
    }

    /**
     * Method under test: {@link CardService#updateCardBalance(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCardBalance5() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at io.meighen_bank_operationer.service.banking.BankingCaller.updateCardBalance(BankingCaller.java:29)
        //       at io.meighen_bank_operationer.service.CardService.updateCardBalance(CardService.java:181)
        //   In order to prevent updateCardBalance(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateCardBalance(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");

        LithicCardDetails lithicCardDetails1 = new LithicCardDetails();
        lithicCardDetails1.setAccount_name("Dr Jane Doe");
        lithicCardDetails1.setHostname("localhost");
        lithicCardDetails1.setId(123L);
        lithicCardDetails1.setNickname("Nickname");
        lithicCardDetails1.setSpend_limit(3);
        lithicCardDetails1.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails1.setState("MD");
        lithicCardDetails1.setToken("ABC123");
        lithicCardDetails1.setType("Type");
        Card card = mock(Card.class);
        when(card.getCardIssuerName()).thenThrow(new RuntimeException("An error occurred"));
        when(card.isLithicCard()).thenReturn(false);
        when(card.isOtherCard()).thenReturn(false);
        when(card.getLithicCardDetails()).thenReturn(lithicCardDetails1);
        doNothing().when(card).setId(anyLong());
        doNothing().when(card).setBalance(anyDouble());
        doNothing().when(card).setCardIssuerName((String) any());
        doNothing().when(card).setCardStatus((CardStatus) any());
        doNothing().when(card).setCard_number((String) any());
        doNothing().when(card).setCreated((Date) any());
        doNothing().when(card).setCvv(anyInt());
        doNothing().when(card).setExpDate((Date) any());
        doNothing().when(card).setExpDay(anyInt());
        doNothing().when(card).setExpMonth(anyInt());
        doNothing().when(card).setExpYear(anyInt());
        doNothing().when(card).setLastFour((String) any());
        doNothing().when(card).setLithicCard(anyBoolean());
        doNothing().when(card).setLithicCardDetails((LithicCardDetails) any());
        doNothing().when(card).setOtherCard(anyBoolean());
        doNothing().when(card).setOtherCardDetail((OtherCardDetail) any());
        doNothing().when(card).setUpdated((Date) any());
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(1);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(true);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        Optional<Card> ofResult = Optional.of(card);
        when(this.cardRepository.findById((Long) any())).thenReturn(ofResult);
        this.cardService.updateCardBalance(1L);
    }

    /**
     * Method under test: {@link CardService#performTransaction(String, String, String, String, String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPerformTransaction() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.StringIndexOutOfBoundsException: begin 2, end 4, length 1
        //       at java.lang.String.checkBoundsBeginEnd(String.java:3319)
        //       at java.lang.String.substring(String.java:1874)
        //       at io.meighen_bank_operationer.service.CardService.performTransaction(CardService.java:191)
        //   In order to prevent performTransaction(String, String, String, String, String, String, String)
        //   from throwing StringIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   performTransaction(String, String, String, String, String, String, String).
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");

        Card card = new Card();
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(1);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(true);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        Optional<Card> ofResult1 = Optional.of(card);
        when(this.cardRepository.findCardByCard_number((String) any())).thenReturn(ofResult1);
        this.cardService.performTransaction("jane.doe@example.org", "alice.liddell@example.org", "Type",
                "jane.doe@example.org", "Ammount", "jane.doe@example.org", "2020-03-01");
    }

    /**
     * Method under test: {@link CardService#performTransaction(String, String, String, String, String, String, String)}
     */
    @Test
    void testPerformTransaction2() {
        when(this.userRepository.findByEmail((String) any())).thenThrow(new RuntimeException("An error occurred"));

        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");

        Card card = new Card();
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(1);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(true);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        Optional<Card> ofResult = Optional.of(card);
        when(this.cardRepository.findCardByCard_number((String) any())).thenReturn(ofResult);
        assertThrows(RuntimeException.class, () -> this.cardService.performTransaction("jane.doe@example.org",
                "alice.liddell@example.org", "Type", "jane.doe@example.org", "Ammount", "jane.doe@example.org", "2020-03-01"));
        verify(this.userRepository).findByEmail((String) any());
        verify(this.cardRepository).findCardByCard_number((String) any());
    }

    /**
     * Method under test: {@link CardService#performTransaction(String, String, String, String, String, String, String)}
     */
    @Test
    void testPerformTransaction3() {
        when(this.userRepository.findByEmail((String) any())).thenReturn(Optional.empty());

        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");

        Card card = new Card();
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(1);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(true);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        Optional<Card> ofResult = Optional.of(card);
        when(this.cardRepository.findCardByCard_number((String) any())).thenReturn(ofResult);
        assertThrows(RuntimeException.class, () -> this.cardService.performTransaction("jane.doe@example.org",
                "alice.liddell@example.org", "Type", "jane.doe@example.org", "Ammount", "jane.doe@example.org", "2020-03-01"));
        verify(this.userRepository).findByEmail((String) any());
        verify(this.cardRepository).findCardByCard_number((String) any());
    }

    /**
     * Method under test: {@link CardService#performTransaction(String, String, String, String, String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPerformTransaction4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NumberFormatException: For input string: "jane.doe@example.org"
        //       at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //       at java.lang.Integer.parseInt(Integer.java:652)
        //       at java.lang.Integer.valueOf(Integer.java:983)
        //       at io.meighen_bank_operationer.service.CardService.performTransaction(CardService.java:195)
        //   In order to prevent performTransaction(String, String, String, String, String, String, String)
        //   from throwing NumberFormatException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   performTransaction(String, String, String, String, String, String, String).
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
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByEmail((String) any())).thenReturn(ofResult);

        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");

        Card card = new Card();
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(Integer.MIN_VALUE);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(true);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        Optional<Card> ofResult1 = Optional.of(card);
        when(this.cardRepository.findCardByCard_number((String) any())).thenReturn(ofResult1);
        this.cardService.performTransaction("jane.doe@example.org", "alice.liddell@example.org", "Type",
                "jane.doe@example.org", "Ammount", "jane.doe@example.org", "2020-03-01");
    }

    /**
     * Method under test: {@link CardService#doTransferToCard(Card, String, User, Double)}
     */
    @Test
    void testDoTransferToCard() {
        Transaction transaction = new Transaction();
        transaction.setAccountOpened(1234567890L);
        transaction.setAmmount(10.0d);
        transaction.setCompleted(true);
        transaction.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        transaction.setOpened(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        transaction.setPerformed(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        transaction.setSendFrom("jane.doe@example.org");
        transaction.setSendTo("alice.liddell@example.org");
        transaction.setTFromSource("jane.doe@example.org");
        transaction.setTToSource("T To Source");
        transaction.setTType("T Type");
        when(this.transactionRepository.save((Transaction) any())).thenReturn(transaction);

        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");

        Card card = new Card();
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(1);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(true);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail);
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        Optional<Card> ofResult = Optional.of(card);
        when(this.cardRepository.findCardByCard_number((String) any())).thenReturn(ofResult);

        CardStatus cardStatus1 = new CardStatus();
        cardStatus1.setId(123L);
        cardStatus1.setName("Name");

        LithicCardDetails lithicCardDetails1 = new LithicCardDetails();
        lithicCardDetails1.setAccount_name("Dr Jane Doe");
        lithicCardDetails1.setHostname("localhost");
        lithicCardDetails1.setId(123L);
        lithicCardDetails1.setNickname("Nickname");
        lithicCardDetails1.setSpend_limit(3);
        lithicCardDetails1.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails1.setState("MD");
        lithicCardDetails1.setToken("ABC123");
        lithicCardDetails1.setType("Type");

        OtherCardDetail otherCardDetail1 = new OtherCardDetail();
        otherCardDetail1.setAccountId("42");
        otherCardDetail1.setCountryCode("GB");
        otherCardDetail1.setFirstNumbers("42");
        otherCardDetail1.setId(123L);
        otherCardDetail1.setLive(true);
        otherCardDetail1.setProgramId("42");
        otherCardDetail1.setScheme("Scheme");
        otherCardDetail1.setType("Type");

        Card card1 = new Card();
        card1.setBalance(10.0d);
        card1.setCardIssuerName("Card Issuer Name");
        card1.setCardStatus(cardStatus1);
        card1.setCard_number("42");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card1.setCreated(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        card1.setCvv(1);
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card1.setExpDate(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        card1.setExpDay(1);
        card1.setExpMonth(1);
        card1.setExpYear(1);
        card1.setId(123L);
        card1.setLastFour("Last Four");
        card1.setLithicCard(true);
        card1.setLithicCardDetails(lithicCardDetails1);
        card1.setOtherCard(true);
        card1.setOtherCardDetail(otherCardDetail1);
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card1.setUpdated(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));

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
        this.cardService.doTransferToCard(card1, "alice.liddell@example.org", user, 10.0d);
        verify(this.transactionRepository).save((Transaction) any());
        verify(this.cardRepository).findCardByCard_number((String) any());
    }

    /**
     * Method under test: {@link CardService#doTransferToCard(Card, String, User, Double)}
     */
    @Test
    void testDoTransferToCard2() {
        Transaction transaction = new Transaction();
        transaction.setAccountOpened(1234567890L);
        transaction.setAmmount(10.0d);
        transaction.setCompleted(true);
        transaction.setId(123L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        transaction.setOpened(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        transaction.setPerformed(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        transaction.setSendFrom("jane.doe@example.org");
        transaction.setSendTo("alice.liddell@example.org");
        transaction.setTFromSource("jane.doe@example.org");
        transaction.setTToSource("T To Source");
        transaction.setTType("T Type");
        when(this.transactionRepository.save((Transaction) any())).thenReturn(transaction);
        when(this.cardRepository.findCardByCard_number((String) any()))
                .thenThrow(new RuntimeException("An error occurred"));

        CardStatus cardStatus = new CardStatus();
        cardStatus.setId(123L);
        cardStatus.setName("Name");

        LithicCardDetails lithicCardDetails = new LithicCardDetails();
        lithicCardDetails.setAccount_name("Dr Jane Doe");
        lithicCardDetails.setHostname("localhost");
        lithicCardDetails.setId(123L);
        lithicCardDetails.setNickname("Nickname");
        lithicCardDetails.setSpend_limit(3);
        lithicCardDetails.setSpend_limit_duration("Spend limit duration");
        lithicCardDetails.setState("MD");
        lithicCardDetails.setToken("ABC123");
        lithicCardDetails.setType("Type");

        OtherCardDetail otherCardDetail = new OtherCardDetail();
        otherCardDetail.setAccountId("42");
        otherCardDetail.setCountryCode("GB");
        otherCardDetail.setFirstNumbers("42");
        otherCardDetail.setId(123L);
        otherCardDetail.setLive(true);
        otherCardDetail.setProgramId("42");
        otherCardDetail.setScheme("Scheme");
        otherCardDetail.setType("Type");

        Card card = new Card();
        card.setBalance(10.0d);
        card.setCardIssuerName("Card Issuer Name");
        card.setCardStatus(cardStatus);
        card.setCard_number("42");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setCreated(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        card.setCvv(1);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setExpDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        card.setExpDay(1);
        card.setExpMonth(1);
        card.setExpYear(1);
        card.setId(123L);
        card.setLastFour("Last Four");
        card.setLithicCard(true);
        card.setLithicCardDetails(lithicCardDetails);
        card.setOtherCard(true);
        card.setOtherCardDetail(otherCardDetail);
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card.setUpdated(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));

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
        this.cardService.doTransferToCard(card, "alice.liddell@example.org", user, 10.0d);
        verify(this.transactionRepository).save((Transaction) any());
        verify(this.cardRepository).findCardByCard_number((String) any());
    }
}

