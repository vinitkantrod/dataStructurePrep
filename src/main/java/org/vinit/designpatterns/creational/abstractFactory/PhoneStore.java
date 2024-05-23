package org.vinit.designpatterns.creational.abstractFactory;

public class PhoneStore {
    AbstractFactory phoneFactory;
    public PhoneStore() {}
    public Phone getPhone(String brand, String model) {
        if (brand.equals(Constants.APPLE)) {
            return AppleFactory.getPhone(model);
        } else if (brand.equals(Constants.SAMSUNG)) {
            return SamsungFactory.getPhone(model);
        }
        return new NullPhone();
    }
}
