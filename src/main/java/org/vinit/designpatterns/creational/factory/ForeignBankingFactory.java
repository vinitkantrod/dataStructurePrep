package org.vinit.designpatterns.creational.factory;

public class ForeignBankingFactory extends AbstractFactory{
    @Override
    public BankAccount createAccount(String type) {
        BankAccount bankAccount = null;
        if (type.equals("P") || type.equals("p")) {
            bankAccount = new PersonalAccount(8.42D, 1_000_123L);
        } else if (type.equals("B") || type.equals("b")) {
            bankAccount = new BusinessAccount(7.25D, 2_000_123L);
        }
        return bankAccount;
    }
}
