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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {LithicBanking.class})
@ExtendWith(SpringExtension.class)
class LithicBankingTest {
    @Autowired
    private LithicBanking lithicBanking;

    /**
     * Method under test: {@link LithicBanking#createCard()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCard() throws IOException, ParseException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        this.lithicBanking.createCard();
    }

    /**
     * Method under test: {@link LithicBanking#changeCardState(Card, String)}
     */
    @Test
    void testChangeCardState() throws IOException {
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
        this.lithicBanking.changeCardState(card, "MD");
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
    }

    /**
     * Method under test: {@link LithicBanking#getCardsDetail(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCardsDetail() throws IOException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        this.lithicBanking.getCardsDetail("ABC123");
    }

    /**
     * Method under test: {@link LithicBanking#getCardsDetail(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCardsDetail2() throws IOException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        this.lithicBanking.getCardsDetail("api-key 42f1d153-1bf2-4179-8869-3479ab823c25");
    }

    /**
     * Method under test: {@link LithicBanking#getCardsDetail(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetCardsDetail3() throws IOException {
        // TODO: Complete this test.
        //   Reason: R011 Sandboxing policy violation.
        //   Diffblue Cover ran code in your project that tried
        //     to access the network.
        //   Diffblue Cover's default sandboxing policy disallows this in order to prevent
        //   your code from damaging your system environment.
        //   See https://diff.blue/R011 to resolve this issue.

        this.lithicBanking
                .getCardsDetail("api-key 42f1d153-1bf2-4179-8869-3479ab823c25api-key 42f1d153-1bf2-4179-8869-3479ab823c25");
    }

    /**
     * Method under test: {@link LithicBanking#subtractMoney(Card, Double)}
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
        assertFalse(this.lithicBanking.subtractMoney(card, 10.0d));
    }

    /**
     * Method under test: {@link LithicBanking#getMoney(Card, Double)}
     */
    @Test
    void testGetMoney() {
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
        assertFalse(this.lithicBanking.getMoney(card, 10.0d));
    }
}

