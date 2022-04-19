package io.meighen_bank_presenter.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="lithic_card_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LithicCardDetails extends BaseEntity {
    protected String hostname;
    protected int spend_limit;
    protected String spend_limit_duration;
    protected String state;
    protected String token;
    protected String type;
    protected String nickname;
    protected String account_name;
}
