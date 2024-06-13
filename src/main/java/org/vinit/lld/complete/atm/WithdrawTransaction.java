package org.vinit.lld.complete.atm;

public class WithdrawTransaction extends Transaction{

    public WithdrawTransaction(String id, Account acc, Double d) {
        super(id, acc, d);
    }
    @Override
    public void execute() {

    }
}
