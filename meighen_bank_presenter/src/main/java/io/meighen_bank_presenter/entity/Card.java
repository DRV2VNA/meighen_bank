package io.meighen_bank_presenter.entity;

import java.util.Date;

import javax.persistence.Entity;
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
    protected int expYear;
    protected Date expDate;
    protected String programId;
    protected String card_id;
    protected String scheme;
    protected String accountId;
    protected String countryCode;
    protected Date created;
    protected boolean live;
    protected String lastNumbers;
    protected int expMonth;
    protected Date updated;
    protected String firstNumbers;
    protected String type;
}
