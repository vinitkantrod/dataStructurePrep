package org.vinit.designpatterns.creational.abstractFactory;

public class AbstractFactoryMain {

    public static void main(String[] args) {
        CarAbstractFactory harrierFactory = CarAbstractFactory.getFactory(CarModelEnum.TATA_HARRIER);
        AbstractDashboard ds = harrierFactory.createDashboard();
    }
}
