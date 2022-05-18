package io.meighen_bank_operationer.service.banking;

import io.meighen_bank_operationer.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankingFactory {
    @Autowired
    LithicBanking lithicBanking;

    @Autowired
    InternalBankingVisa internalBankingVisa;

    @Autowired
    InternalBankingMastercard internalBankingMastercard;

    public BankingService createBankingService(Card card) {
        BankingService bankingService = null;

        if (card.isLithicCard()) {
            bankingService = lithicBanking;
        } else if (card.isOtherCard()) {
            if (card.getCardIssuerName().equals("Visa")) {
                bankingService = internalBankingVisa;
            } else if (card.getCardIssuerName().equals("Mastercard")) {
                bankingService = internalBankingMastercard;
            }
        }

        return bankingService;
    }

    public BankingService createLithicService() {
        return lithicBanking;
    }

    public BankingService createInternalServiceVisa() {
        return internalBankingVisa;
    }

    public BankingService createInternalServiceMastercard() {
        return internalBankingMastercard;
    }
}
