package io.meighen_bank_presenter.dto;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class DailyTransactionsDto {
//    @JsonFormat(pattern="yyyy-MM-dd")
    private String transactionDate;
}
