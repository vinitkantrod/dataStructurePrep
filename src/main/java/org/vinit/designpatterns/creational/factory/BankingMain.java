package org.vinit.designpatterns.creational.factory;

import java.util.Scanner;

public class BankingMain {

    public static void main(String[] args) {
        System.out.println("Welcome to ICICI Bank");
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter\n" +
                " P for Personal account\n" +
                " B for Business account\n" +
                "----------------------------");
        String type = in.next();
        BankAccount acc = BankingFactory.createAccount(type.toUpperCase());
        System.out.println(acc.getInterestRate() + ", " + acc.getLimitToAccountBalance());
    }
}
