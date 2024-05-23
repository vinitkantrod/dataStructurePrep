package org.vinit.designpatterns.creational.factory;

public class BusinessAccount implements BankAccount {
    public Double interestRate;
    public Long accNumber;
    public Long accountLimit;
    public BusinessAccount(double interestRate, Long accNumber) {
        this.interestRate = interestRate;
        this.accountLimit = 1_000_000L;
        this.accNumber = accNumber;
    }
    @Override
    public Long getLimitToAccountBalance() {
        return this.accountLimit;
    }

    @Override
    public Double getInterestRate() {
        return this.interestRate;
    }

    @Override
    public Long getAccountNumber() {
        return this.accNumber;
    }
}
