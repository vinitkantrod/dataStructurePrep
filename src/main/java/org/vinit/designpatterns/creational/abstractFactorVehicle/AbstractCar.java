package org.vinit.designpatterns.creational.abstractFactorVehicle;

public interface AbstractCar {
    public void addTyreOfSize(int frontType, int backTypre);
    public void addDashboard(int size);
    public void addSeatSize(int totalSeats);
    public void addEngine();
    public String getName();
    public String toString();
}
