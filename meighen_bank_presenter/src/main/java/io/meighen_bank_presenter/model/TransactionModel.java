package io.meighen_bank_presenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionModel {
    protected String operation;
    protected String email;

    protected String from;
    protected String to;
    protected String type;
    protected String ammount;


    protected String fromcvv;
    protected String fromvaliddate;
}
