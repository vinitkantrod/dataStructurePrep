package org.vinit.lld.complete.atm;

import lombok.Getter;

public class Account {
    private final String accountNumber;
    private Double balance;
    public Account(String accNo, Double balance) {
        this.accountNumber = accNo;
        this.balance = balance;
    }
    public Double getBalance() {return this.balance;}
    public String getAccountNumber() {return this.accountNumber;}

    public void debit(Double a) {
        if (a > balance) throw new IllegalArgumentException("Low balance. You have " + balance + " amount in your account.");
        balance -= a;
    }
    public void credit(Double a) {balance += a;}
}
