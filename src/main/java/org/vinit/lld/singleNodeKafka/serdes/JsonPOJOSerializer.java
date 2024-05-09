package org.vinit.lld.singleNodeKafka.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonPOJOSerializer<T> implements Serializer<T> {

    public final ObjectMapper objectMapper = new ObjectMapper();
    public JsonPOJOSerializer() {}

    @Override
    public void configure(Map<String, ?> config, boolean isKey) {
        Serializer.super.configure(config, isKey);
    }

    @Override
    public byte[] serialize(String topic, T data) throws Exception {
        if (data == null)
            return null;

        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error serializing JSON message");
        }
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
    public void printData() {
        System.out.println(objectMapper);
    }
}
