package io.meighen_bank_operationer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Kafka msg.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KafkaMsg {
    private String body;
}
