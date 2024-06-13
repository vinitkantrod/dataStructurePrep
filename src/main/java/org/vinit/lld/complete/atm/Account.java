package org.vinit.lld.complete.atm;

import lombok.Getter;

public class Account {
    private final String accountNumber;
    private Double balance;
    public Account(String accNo, Double balance) {
        this.accountNumber = accNo;
        this.balance = balance;
    }
    private Double getBalance() {return this.balance;}
    private String getAccountNumber() {return this.accountNumber;}

}
