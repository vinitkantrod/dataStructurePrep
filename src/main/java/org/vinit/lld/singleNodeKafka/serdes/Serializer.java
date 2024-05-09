package org.vinit.lld.singleNodeKafka.serdes;

import java.util.Map;

public interface Serializer<T> extends Cloneable {
    default void configure(Map<String, ?> config, boolean isKey) {}
    byte[] serialize(String topic, T data) throws Exception;

    default byte[] serialize(String topic, Map<String, ?> headers, T data) throws Exception {
        return serialize(topic, data);
    }
    default void close() {}
}
