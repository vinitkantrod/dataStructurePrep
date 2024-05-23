package org.vinit.designpatterns.creational.factory;

public class Branch {

    private AbstractFactory bankingFactory;

    public Branch(AbstractFactory _factory) {
        this.bankingFactory = _factory;
    }
    public BankAccount openAccount(String type) {
        BankAccount acc = bankingFactory.createAccount(type);
        return acc;
    }
}
