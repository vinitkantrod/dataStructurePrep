package org.vinit.designpatterns.creational.abstractFactory;

public class NullPhone implements Phone {
    public NullPhone() {}
    @Override
    public String getDescription() {
        return "Invalid Model supplied. No Phone available for the given model";
    }
}
