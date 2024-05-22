package org.vinit.designpatterns.creational.abstractFactory;

public class KiaSeltosToolKit extends CarAbstractFactory {
    @Override
    public AbstractTyre createTyre() {
        return new KiaSeltosTyre();
    }

    @Override
    public AbstractDashboard createDashboard() {
        return new KiaSeltosDashboard();
    }
}
