package org.vinit.designpatterns.creational.abstractFactory;

public class SamsungFactory implements AbstractFactory {
    public static Phone getPhone(String model) {
        Phone p = new NullPhone();
        if (model.equals(Constants.S_23)) {
            p = new S23();
        } else if (model.equals(Constants.S_23_ULTRA)) {
            p = new S23Ultra();
        }
        return p;
    }
}
