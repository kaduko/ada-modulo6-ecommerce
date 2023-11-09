package com.example.adamodulo6ecommerce.estoque.config.kafka;

import com.example.adamodulo6ecommerce.estoque.adapters.event.VendaEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.hibernate.type.SerializationException;

public class CustomDeserializerKafka implements Deserializer<VendaEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public VendaEvent deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                return null;
            }
            return objectMapper.readValue(new String(data, "UTF-8"), VendaEvent.class);
        } catch (Exception e) {
           // throw new SerializationException("Error when deserializing byte[] to SaleMessage");
            return null;
        }
    }
}