package io.meighen_bank_operationer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="cards_statuses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardStatus extends BaseEntity{
    @Column
    private String name;
}
