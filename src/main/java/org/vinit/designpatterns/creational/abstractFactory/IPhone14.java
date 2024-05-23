package org.vinit.designpatterns.creational.abstractFactory;

public class IPhone14 implements Phone {
    String modelName;
    String screenSize;
    Long price;
    public IPhone14() {
        this.modelName = Constants.I_PHONE_14;
        this.screenSize = "6.06 inch";
        this.price = 150_000L;
    }

    @Override
    public String getDescription() {
        return """
                %s comes with %s screen size and price is %s
                """.formatted(this.modelName, this.screenSize, this.price);
    }
}
