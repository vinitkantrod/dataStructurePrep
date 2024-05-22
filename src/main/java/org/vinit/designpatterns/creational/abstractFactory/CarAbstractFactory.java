package org.vinit.designpatterns.creational.abstractFactory;

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
