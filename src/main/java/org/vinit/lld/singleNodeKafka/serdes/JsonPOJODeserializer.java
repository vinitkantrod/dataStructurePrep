package org.vinit.lld.singleNodeKafka.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonPOJODeserializer<T> implements Deserializer<T> {
    private ObjectMapper objectMapper = new ObjectMapper();
    private Class<T> tClass;
    public JsonPOJODeserializer() {}
    @SuppressWarnings("unchecked")
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        tClass = (Class<T>) configs.get("JsonPOJOClass");
    }

    @Override
    public T deserialize(String topic, byte[] bytes) throws Exception {
        if (bytes == null) return null;
        T data;
        try {
            data = objectMapper.readValue(bytes, tClass);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return data;
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
