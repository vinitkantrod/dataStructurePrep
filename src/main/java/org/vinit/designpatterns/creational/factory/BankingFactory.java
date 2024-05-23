package org.vinit.designpatterns.creational.factory;

public class BankingFactory {

    public static BankAccount createAccount(String type) {
        BankAccount bankAccount = null;
        switch (type) {
            case "P" -> {
                bankAccount = new PersonalAccount(8.5D, 1_000_567L);
                break;
            }
            case "B" -> {
                bankAccount = new BusinessAccount(7.0D, 2_000_567L);
                break;
            }
        }
//        System.out.println(bankAccount.getLimitToAccountBalance());
//        System.out.println(bankAccount.getAccountNumber());
//        System.out.println(bankAccount.getInterestRate());
        return bankAccount;
    }
}
