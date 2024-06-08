package org.vinit.lld.inMemorySqlDatabase;

public class IntDataType extends ColumnDataType {
    private int minValue;
    private int maxValue;
    public IntDataType(int min, int max) {
        super(0);
        this.maxValue = max;
        this.minValue = min;
    }
    @Override
    public boolean validate(Object val) {
        return false;
    }
}
