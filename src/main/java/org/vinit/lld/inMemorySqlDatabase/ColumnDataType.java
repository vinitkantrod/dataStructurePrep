package org.vinit.lld.inMemorySqlDatabase;

public abstract class ColumnDataType<T> {

    private T dataType;
    public ColumnDataType(T dt) {
        this.dataType = dt;
    }
    public abstract <T> boolean validate(T val);
}
