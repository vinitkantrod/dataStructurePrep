package org.vinit.designpatterns.creational.abstractFactory;

public class S23Ultra implements Phone {
    String modelName;
    String screenSize;
    Long price;
    public S23Ultra() {
        this.modelName = Constants.S_23_ULTRA;
        this.screenSize = "7.14 inch";
        this.price = 175_000L;
    }

    @Override
    public String getDescription() {
        return """
                %s comes with %s screen size and price is %s
                """.formatted(this.modelName, this.screenSize, this.price);
    }
}
