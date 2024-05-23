package org.vinit.designpatterns.creational.abstractFactorVehicle;

public class CarFactory {
    public static final TataHarrierCar HARRIER = new TataHarrierCar();
    public static final KiaSeltosCar SELTOS = new KiaSeltosCar();

    public static AbstractCar getCar(CarModelEnum model) {
        AbstractCar factory = null;
        switch (model) {
            case TATA_HARRIER -> {
                factory = HARRIER;
                break;
            }
            case KIA_SELTOS -> {
                factory = SELTOS;
                break;
            }
        }
        return factory;
    }
}
