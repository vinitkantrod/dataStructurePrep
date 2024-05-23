package org.vinit.designpatterns.creational.abstractFactorVehicle;

public class VehicleMain {
    public static void main(String[] args) {
        AbstractCar harrierCar = CarFactory.getCar(CarModelEnum.TATA_HARRIER);
        System.out.println(harrierCar.toString());
        AbstractCar seltosCar = CarFactory.getCar(CarModelEnum.KIA_SELTOS);
        System.out.println(seltosCar.toString());

    }
}
