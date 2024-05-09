package org.vinit.lld.singleNodeKafka.serdes;

import java.nio.ByteBuffer;
import java.util.Map;

public interface Deserializer<T> extends Cloneable {
    default void configure(Map<String, ?> configs, boolean isKey) {}

    T deserialize(String topic, byte[] bytes) throws Exception;

    default T deserialize(String topic, Map<String, ?> headers, byte[] bytes) throws Exception {
        return deserialize(topic, bytes);
    }

    default void close() {}
}
