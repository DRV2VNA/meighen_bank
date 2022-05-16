package io.meighen_bank_presenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardModel {
    protected String operation;
    protected String email;

    protected String cardSystem;
    protected String currency;
}
