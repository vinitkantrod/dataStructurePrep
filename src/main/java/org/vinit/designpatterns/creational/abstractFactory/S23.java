package org.vinit.designpatterns.creational.abstractFactory;

public class S23 implements Phone {
    String modelName;
    String screenSize;
    Long price;
    public S23() {
        this.modelName = Constants.S_23;
        this.screenSize = "6.2 inch";
        this.price = 130_000L;
    }

    @Override
    public String getDescription() {
        return """
                %s comes with %s screen size and price is %s
                """.formatted(this.modelName, this.screenSize, this.price);
    }
}
