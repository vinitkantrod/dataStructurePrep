package org.vinit.lld.complete.atm;

public abstract class Transaction {
    protected final String transactionId;
    protected final Account account;
    protected final Double amount;
    public Transaction(String id, Account acc, Double d) {
        this.transactionId = id;
        this.account = acc;
        this.amount = d;
    }

    public abstract void execute();
}
