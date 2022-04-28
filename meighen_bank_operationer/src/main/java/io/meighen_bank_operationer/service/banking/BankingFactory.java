package io.meighen_bank_operationer.service.banking;

import io.meighen_bank_operationer.entity.Card;
import org.springframework.stereotype.Service;

@Service
public class BankingFactory {
    public BankingService createBankingService(Card card) {
        BankingService bankingService = null;

        if (card.isLithicCard()) {
            bankingService = new LithicBanking();
        } else if (card.isOtherCard()) {
            //bankingService = new OtherBanking();
        }

        return bankingService;
    }

    public BankingService createLithicService() {
        return new LithicBanking();
    }
}
