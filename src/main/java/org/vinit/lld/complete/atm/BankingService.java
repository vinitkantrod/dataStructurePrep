package org.vinit.lld.complete.atm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankingService {
    Map<String, Account> accounts = new ConcurrentHashMap<>();
    public BankingService() {}

    public void createAccount(String acc, Double bal) {
        System.out.println("Creating New Account for " + acc);
        accounts.put(acc, new Account(acc, bal));
    }
    public Account getAccount(String accNo) {
        return accounts.getOrDefault(accNo, null);
    }

    public void processTransaction(Transaction transaction) {
        transaction.execute();
    }
}
