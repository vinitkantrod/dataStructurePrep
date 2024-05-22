package org.vinit.designpatterns.creational.abstractFactory;

import org.vinit.designpatterns.creational.abstractFactory.carFactory.CarAbstractFactory;
import org.vinit.designpatterns.creational.abstractFactory.dashboard.AbstractDashboard;

public class AbstractFactoryMain {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        CarAbstractFactory harrierFactory = CarAbstractFactory.getFactory(CarModelEnum.TATA_HARRIER);
        AbstractDashboard ds = harrierFactory.createDashboard();
    }
}
