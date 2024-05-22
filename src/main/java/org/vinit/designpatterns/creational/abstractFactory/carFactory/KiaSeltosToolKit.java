package org.vinit.designpatterns.creational.abstractFactory.carFactory;

import org.vinit.designpatterns.creational.abstractFactory.carFactory.CarAbstractFactory;
import org.vinit.designpatterns.creational.abstractFactory.dashboard.AbstractDashboard;
import org.vinit.designpatterns.creational.abstractFactory.dashboard.KiaSeltosDashboard;
import org.vinit.designpatterns.creational.abstractFactory.tyre.AbstractTyre;
import org.vinit.designpatterns.creational.abstractFactory.tyre.KiaSeltosTyre;

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
