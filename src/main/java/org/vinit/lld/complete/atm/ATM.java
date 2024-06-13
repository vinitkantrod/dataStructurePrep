package org.vinit.lld.complete.atm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

public class ATM {
    private final BankingService bankingService;
    private final CashDispenser cashDispenser;
    private static final AtomicLong counter = new AtomicLong(0);

    public ATM(BankingService bs, CashDispenser cd) {
        this.bankingService = bs;
        this.cashDispenser = cd;
    }
    public void AuthenticateCard(Card card) {
        // authentication logic

    }
    public Double checkBalance(String acc) {
        return bankingService.getAccount(acc).getBalance();
    }
    public void withdrawCash(String acc, Double amount) {
        Account account = bankingService.getAccount(acc);
        Transaction transaction = new WithdrawTransaction(generateTransactionId(), account, amount);
        Boolean isTransactionSuccess = true;
        Boolean isAmountDebited = false;
        try {
            bankingService.processTransaction(transaction);
            isAmountDebited = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            isTransactionSuccess = false;
            return;
        }
        try {
            cashDispenser.dispenseCash(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            isTransactionSuccess = false;
        }
        if (!isTransactionSuccess) {
            if(isAmountDebited) {
                Transaction txn = new DepositeTransaction(generateTransactionId(), account, amount);
                // What if this process fails.
                bankingService.processTransaction(txn);
            }
        }
    }
    public void depositeCash(String acc, Double amount) {
        Account account = bankingService.getAccount(acc);
        Transaction transaction = new DepositeTransaction(generateTransactionId(), account, amount);
        bankingService.processTransaction(transaction);
    }
    private String generateTransactionId() {
        Long id = counter.incrementAndGet();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "TXN" + timestamp + String.format("%010d", id);
    }
}
