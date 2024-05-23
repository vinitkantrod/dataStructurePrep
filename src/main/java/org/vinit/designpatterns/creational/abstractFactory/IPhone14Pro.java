package org.vinit.designpatterns.creational.abstractFactory;

public class IPhone14Pro implements Phone {
    String modelName;
    String screenSize;
    Long price;
    public IPhone14Pro() {
        this.modelName = Constants.I_PHONE_14_PRO;
        this.screenSize = "7.0 inch";
        this.price = 199_000L;
    }

    @Override
    public String getDescription() {
        return """
                %s comes with %s screen size and price is %s
                """.formatted(this.modelName, this.screenSize, this.price);
    }
}
