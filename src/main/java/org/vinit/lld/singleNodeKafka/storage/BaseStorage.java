package org.vinit.lld.singleNodeKafka.storage;

public abstract class BaseStorage<T> {
    public Class<T> tClass;
    public BaseStorage(Class<T> dataClass) {
        tClass = dataClass;
    }
}
