package io.meighen_bank_operationer.service.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.meighen_bank_operationer.entity.Card;
import io.meighen_bank_operationer.entity.CardStatus;
import io.meighen_bank_operationer.entity.LithicCardDetails;
import io.meighen_bank_operationer.entity.OtherCardDetail;

import java.io.IOException;
import java.text.ParseException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BankingCallerTest {
    @Autowired
    private BankingCaller bankingCaller;

    /**
     * Method under test: {@link BankingCaller#createLithicCard()}
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

        this.bankingCaller.createLithicCard();
    }

    /**
     * Method under test: {@link BankingCaller#changeCardStatus(Card, String)}
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
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        card.setCreated(fromResult);
        card.setCvv(1);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        card.setExpDate(fromResult1);
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
        Date fromResult2 = Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant());
        card.setUpdated(fromResult2);
        this.bankingCaller.changeCardStatus(card, "Status");
        assertEquals(10.0d, card.getBalance());
        assertTrue(card.isOtherCard());
        assertTrue(card.isLithicCard());
        assertSame(fromResult2, card.getUpdated());
        assertSame(otherCardDetail, card.getOtherCardDetail());
        assertSame(lithicCardDetails, card.getLithicCardDetails());
        assertEquals("Card Issuer Name", card.getCardIssuerName());
        assertEquals("42", card.getCard_number());
        assertEquals(1, card.getExpDay());
        assertEquals(1, card.getExpMonth());
        assertSame(fromResult, card.getCreated());
        assertEquals(1, card.getExpYear());
        assertEquals(123L, card.getId());
        assertSame(cardStatus, card.getCardStatus());
        assertEquals(1, card.getCvv());
        assertEquals("Last Four", card.getLastFour());
        assertSame(fromResult1, card.getExpDate());
        BankingFactory bankingFactory = this.bankingCaller.factory;
        assertSame(bankingFactory.internalBankingMastercard.cardStatusRepository,
                bankingFactory.internalBankingVisa.cardStatusRepository);
    }

    /**
     * Method under test: {@link BankingCaller#changeCardStatus(Card, String)}
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
        //   In order to prevent changeCardStatus(Card, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   changeCardStatus(Card, String).
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
        this.bankingCaller.changeCardStatus(card, "Status");
    }

    /**
     * Method under test: {@link BankingCaller#updateCardBalance(Card)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCardBalance() throws IOException {
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
        this.bankingCaller.updateCardBalance(card);
    }

    /**
     * Method under test: {@link BankingCaller#updateCardBalance(Card)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateCardBalance2() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at io.meighen_bank_operationer.service.banking.BankingCaller.updateCardBalance(BankingCaller.java:29)
        //   In order to prevent updateCardBalance(Card)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateCardBalance(Card).
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
        this.bankingCaller.updateCardBalance(card);
    }

    /**
     * Method under test: {@link BankingCaller#createVisaCard()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateVisaCard() throws IOException, ParseException {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        this.bankingCaller.createVisaCard();
    }

    /**
     * Method under test: {@link BankingCaller#createMastercardCard()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateMastercardCard() throws IOException, ParseException {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        this.bankingCaller.createMastercardCard();
    }

    /**
     * Method under test: {@link BankingCaller#subtractMoney(Card, Double)}
     */
    @Test
    void testSubtractMoney() {
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
        assertFalse(this.bankingCaller.subtractMoney(card, 10.0d));
    }

    /**
     * Method under test: {@link BankingCaller#subtractMoney(Card, Double)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSubtractMoney2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at io.meighen_bank_operationer.service.banking.BankingCaller.subtractMoney(BankingCaller.java:41)
        //   In order to prevent subtractMoney(Card, Double)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   subtractMoney(Card, Double).
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
        this.bankingCaller.subtractMoney(card, 10.0d);
    }

    /**
     * Method under test: {@link BankingCaller#addMoney(Card, Double)}
     */
    @Test
    void testAddMoney() {
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
        assertFalse(this.bankingCaller.addMoney(card, 10.0d));
    }

    /**
     * Method under test: {@link BankingCaller#addMoney(Card, Double)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddMoney2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at io.meighen_bank_operationer.service.banking.BankingCaller.addMoney(BankingCaller.java:45)
        //   In order to prevent addMoney(Card, Double)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   addMoney(Card, Double).
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
        this.bankingCaller.addMoney(card, 10.0d);
    }
}

