package org.vinit.designpatterns.creational.abstractFactory.carFactory;

import org.vinit.designpatterns.creational.abstractFactory.CarModelEnum;
import org.vinit.designpatterns.creational.abstractFactory.dashboard.AbstractDashboard;
import org.vinit.designpatterns.creational.abstractFactory.tyre.AbstractTyre;

public abstract class CarAbstractFactory {
    private static final TataHarrierToolKit TATA_HARRIER = new TataHarrierToolKit();
    private static final KiaSeltosToolKit KIA_SELTOS = new KiaSeltosToolKit();

    static CarAbstractFactory getFactory(CarModelEnum model) {
        CarAbstractFactory factory = null;
        switch (model) {
            case KIA_SELTOS -> {
                factory = KIA_SELTOS;
                break;
            }
            case TATA_HARRIER -> {
                factory = TATA_HARRIER;
                break;
            }
        }
        return factory;
    }
    public abstract AbstractTyre createTyre();

    public abstract AbstractDashboard createDashboard();
}
