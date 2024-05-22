package org.vinit.designpatterns.creational.abstractFactory;

public class TataHarrierToolKit extends CarAbstractFactory{
    @Override
    public AbstractTyre createTyre() {
        return new TataHarrierTyre();
    }

    @Override
    public AbstractDashboard createDashboard() {
        return new TataHarrierDashboard();
    }
}
