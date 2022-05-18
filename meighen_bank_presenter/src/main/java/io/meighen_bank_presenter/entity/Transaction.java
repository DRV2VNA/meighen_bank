package io.meighen_bank_presenter.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends BaseEntity {
    String sendFrom;
    String sendTo;

    String tFromSource;
    String tToSource;

    boolean completed;

    protected Date opened;
    protected Date performed;

    Long accountOpened;
    Double ammount;

}
