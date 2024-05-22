package org.vinit.designpatterns.creational.abstractFactory.carFactory;

import org.vinit.designpatterns.creational.abstractFactory.carFactory.CarAbstractFactory;
import org.vinit.designpatterns.creational.abstractFactory.dashboard.AbstractDashboard;
import org.vinit.designpatterns.creational.abstractFactory.dashboard.TataHarrierDashboard;
import org.vinit.designpatterns.creational.abstractFactory.tyre.AbstractTyre;
import org.vinit.designpatterns.creational.abstractFactory.tyre.TataHarrierTyre;

public class TataHarrierToolKit extends CarAbstractFactory {
    @Override
    public AbstractTyre createTyre() {
        return new TataHarrierTyre();
    }

    @Override
    public AbstractDashboard createDashboard() {
        return new TataHarrierDashboard();
    }
}
