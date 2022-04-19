package io.meighen_bank_operationer.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="other_card_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtherCardDetail extends BaseEntity{
    protected String programId;
    protected String scheme;
    protected String accountId;
    protected String countryCode;
    protected boolean live;
    protected String firstNumbers;
    protected String type;
}
