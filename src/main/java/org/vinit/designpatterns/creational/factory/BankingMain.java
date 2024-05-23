package org.vinit.designpatterns.creational.factory;

import java.util.Scanner;

public class BankingMain {

    public static void main(String[] args) {
        System.out.println("\n\n\t*******  Welcome to ICICI Local Bank");
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter\n" +
                "P for Personal account\n" +
                "B for Business account\n" +
                "----------------------------");
        String type = in.next();
        Branch localBranch = new Branch(new LocalBankingFactory());
        BankAccount acc = localBranch.openAccount(type);
        System.out.println("Account No: "+ acc.getAccountNumber() +
                "\nat interest rateL " +  acc.getInterestRate() +
                "\nwith limit " + acc.getLimitToAccountBalance());

        System.out.println("\n\n\t*******  Welcome to ICICI Foreign Bank");
        System.out.println("Please enter\n" +
                "P for Personal account\n" +
                "B for Business account\n" +
                "----------------------------");
        type = in.next();
        Branch foreignBranch = new Branch(new ForeignBankingFactory());
        acc = foreignBranch.openAccount(type);
        System.out.println("Account No: "+ acc.getAccountNumber() +
                "\nat interest rateL " +  acc.getInterestRate() +
                "\nwith limit " + acc.getLimitToAccountBalance());
    }
}
