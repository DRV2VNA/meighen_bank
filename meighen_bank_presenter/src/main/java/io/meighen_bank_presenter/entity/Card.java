package io.meighen_bank_presenter.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card extends BaseEntity {
    protected String card_number;
    protected Date created;
    protected Date updated;
    protected int cvv;
    protected Date expDate;
    protected int expYear;
    protected int expMonth;
    protected int expDay;
    protected String lastFour;

    protected boolean isLithicCard;
    protected boolean isOtherCard;
    protected String cardIssuerName;

    protected double balance;

    @OneToOne
    protected CardStatus cardStatus;

    @OneToOne
    protected LithicCardDetails lithicCardDetails;

    @OneToOne
    protected OtherCardDetail otherCardDetail;
}
