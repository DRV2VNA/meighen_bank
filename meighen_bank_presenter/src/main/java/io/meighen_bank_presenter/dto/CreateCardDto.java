package io.meighen_bank_presenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardDto {
    protected int cardSystem;
    protected String currency;

//    protected String name;
}
