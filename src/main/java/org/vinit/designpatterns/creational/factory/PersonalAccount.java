package org.vinit.designpatterns.creational.factory;

public class PersonalAccount implements BankAccount {
    public Double interestRate;
    public Long accNumber;
    public Long accountLimit;
    public PersonalAccount(double interestRate, Long accNumber) {
        this.interestRate = interestRate;
        this.accountLimit = 1_000_00L;
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
