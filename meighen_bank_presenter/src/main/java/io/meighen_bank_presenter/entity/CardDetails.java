package io.meighen_bank_presenter.entity;

import java.util.Date;

public class CardDetails extends BaseEntity {
    protected int cardType; // 1 - Lithic 2 -

    protected String card_number;
    protected Date created;
    protected Date updated;
    protected int cvv;
    protected Date expDate;
    protected int expYear;
    protected int expMonth;
    protected int expDay;
    protected String lastFour;
}
