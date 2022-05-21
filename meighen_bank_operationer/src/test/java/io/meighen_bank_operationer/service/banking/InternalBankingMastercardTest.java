package io.meighen_bank_operationer.service.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.meighen_bank_operationer.entity.Card;
import io.meighen_bank_operationer.entity.CardStatus;
import io.meighen_bank_operationer.entity.LithicCardDetails;
import io.meighen_bank_operationer.entity.OtherCardDetail;
import io.meighen_bank_operationer.repository.CardRepository;
import io.meighen_bank_operationer.repository.CardStatusRepository;
import io.meighen_bank_operationer.repository.OtherCardDetailsRepository;

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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {InternalBankingMastercard.class})
@ExtendWith(SpringExtension.class)
class InternalBankingMastercardTest {
    @MockBean
    private CardRepository cardRepository;

    @MockBean
    private CardStatusRepository cardStatusRepository;

    @Autowired
    private InternalBankingMastercard internalBankingMastercard;

    @MockBean
    private OtherCardDetailsRepository otherCardDetailsRepository;

    /**
     * Method under test: {@link InternalBankingMastercard#createCard()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateCard() throws IOException, ParseException {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        this.internalBankingMastercard.createCard();
    }

    /**
     * Method under test: {@link InternalBankingMastercard#changeCardState(Card, String)}
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
        this.internalBankingMastercard.changeCardState(card, "MD");
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
     * Method under test: {@link InternalBankingMastercard#getCardsDetail(String)}
     */
    @Test
    void testGetCardsDetail() throws IOException {
        assertNull(this.internalBankingMastercard.getCardsDetail("ABC123"));
    }

    /**
     * Method under test: {@link InternalBankingMastercard#subtractMoney(Card, Double)}
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
        assertFalse(this.internalBankingMastercard.subtractMoney(card, 10.0d));
    }

    /**
     * Method under test: {@link InternalBankingMastercard#getMoney(Card, Double)}
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
        when(this.cardRepository.save((Card) any())).thenReturn(card);

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
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card1.setCreated(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        card1.setCvv(1);
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card1.setExpDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        card1.setExpDay(1);
        card1.setExpMonth(1);
        card1.setExpYear(1);
        card1.setId(123L);
        card1.setLastFour("Last Four");
        card1.setLithicCard(true);
        card1.setLithicCardDetails(lithicCardDetails1);
        card1.setOtherCard(true);
        card1.setOtherCardDetail(otherCardDetail1);
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        card1.setUpdated(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        assertTrue(this.internalBankingMastercard.getMoney(card1, 10.0d));
        verify(this.cardRepository).save((Card) any());
        assertEquals(20.0d, card1.getBalance());
    }
}

