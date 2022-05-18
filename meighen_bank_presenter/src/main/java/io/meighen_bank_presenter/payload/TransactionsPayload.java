package io.meighen_bank_presenter.payload;

import java.util.List;

import io.meighen_bank_presenter.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsPayload {
    List<Transaction> transactions;
}
