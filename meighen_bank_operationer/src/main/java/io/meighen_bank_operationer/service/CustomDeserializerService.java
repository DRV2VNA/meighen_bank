package io.meighen_bank_operationer.service;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.meighen_bank_operationer.model.KafkaMsg;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

/**
 * The type Custom deserializer service.
 */
public class CustomDeserializerService implements Deserializer<KafkaMsg> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public KafkaMsg deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                System.out.println("Null received at deserializing");
                return null;
            }
//            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(data, "UTF-8"), KafkaMsg.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SerializationException("Error when deserializing byte[] to MessageDto");
        }
    }

    @Override
    public void close() {
    }
}