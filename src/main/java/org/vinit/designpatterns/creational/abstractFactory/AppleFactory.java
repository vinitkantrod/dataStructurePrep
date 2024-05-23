package org.vinit.designpatterns.creational.abstractFactory;

public class AppleFactory implements AbstractFactory {
    public static Phone getPhone(String model) {
        Phone p = new NullPhone();
        if (model.equals(Constants.I_PHONE_14)) {
            p = new IPhone14();
        } else if (model.equals(Constants.I_PHONE_14_PRO)) {
            p = new IPhone14Pro();
        }
        return p;
    }
}
