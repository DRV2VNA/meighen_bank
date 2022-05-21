package io.meighen_bank_operationer.service.banking;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.meighen_bank_operationer.entity.Card;
import io.meighen_bank_operationer.entity.CardStatus;
import io.meighen_bank_operationer.entity.LithicCardDetails;
import io.meighen_bank_operationer.entity.OtherCardDetail;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class BankingFactoryTest {
    @Autowired
    private BankingFactory bankingFactory;

    /**
     * Method under test: {@link BankingFactory#createBankingService(Card)}
     */
    @Test
    void testCreateBankingService() {
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
        assertTrue(this.bankingFactory.createBankingService(card) instanceof LithicBanking);
    }

    /**
     * Method under test: {@link BankingFactory#createBankingService(Card)}
     */
    @Test
    void testCreateBankingService2() {
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
        assertNull(this.bankingFactory.createBankingService(card));
    }

    /**
     * Method under test: {@link BankingFactory#createLithicService()}
     */
    @Test
    void testCreateLithicService() {
        assertTrue(this.bankingFactory.createLithicService() instanceof LithicBanking);
    }

    /**
     * Method under test: {@link BankingFactory#createInternalServiceVisa()}
     */
    @Test
    void testCreateInternalServiceVisa() {
        assertTrue(this.bankingFactory.createInternalServiceVisa() instanceof InternalBankingVisa);
    }

    /**
     * Method under test: {@link BankingFactory#createInternalServiceMastercard()}
     */
    @Test
    void testCreateInternalServiceMastercard() {
        assertTrue(this.bankingFactory.createInternalServiceMastercard() instanceof InternalBankingMastercard);
    }
}

