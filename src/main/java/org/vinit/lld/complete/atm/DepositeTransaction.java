package org.vinit.lld.complete.atm;

public class DepositeTransaction extends Transaction{

    public DepositeTransaction(String id, Account acc, Double d) {
        super(id, acc, d);
    }
    @Override
    public void execute() {
        account.credit(amount);
    }
}
