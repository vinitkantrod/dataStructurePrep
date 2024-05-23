package org.vinit.designpatterns.creational.abstractFactorVehicle;

public class TataHarrierCar implements AbstractCar {
    int frontTyreSize;
    int backTyreSize;
    int dashboardSize;
    int numberOfSeats;
    String name;
    public TataHarrierCar() {
        this.name = "TATA_HARRIER_CAR";
    }
    @Override
    public void addTyreOfSize(int frontTyre, int backTypre) {
        this.frontTyreSize = frontTyre;
        this.backTyreSize = backTypre;
    }

    @Override
    public void addDashboard(int size) {
        this.dashboardSize = size;
    }

    @Override
    public void addSeatSize(int totalSeats) {
        this.numberOfSeats = totalSeats;
    }

    @Override
    public void addEngine() {

    }

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return """
                Car: %s
                NumberOfSeats: %s
                Rear Tyre Size: %s
                """.formatted(this.name, this.numberOfSeats, this.backTyreSize);
    }
}
