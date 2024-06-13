package org.vinit.lld.complete.atm;

public class CashDispenser {
    private Double cashAvailable;
    public CashDispenser(Double initialBal) {
        System.out.println("Setting Cash Dispenser with initial Amount of " + initialBal);
        this.cashAvailable = initialBal;
    }
    public synchronized void dispenseCash(Double amount) {
        if (cashAvailable < amount) {
            throw new IllegalArgumentException("Not enough cash available in the ATM.");
        }
        cashAvailable -= amount;
        System.out.println("Cash Dispensed: " + amount+". Remaining Bal: " + cashAvailable);
    }
}
