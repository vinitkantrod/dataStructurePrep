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
    public void AuthenticateUser(Card card) {
        // authentication logic

    }
    public Double checkBalance(String acc) {
        return bankingService.getAccount(acc).getBalance();
    }
    public void withdrawCash(String acc, Double amount) {
        Account account = bankingService.getAccount(acc);
        Transaction transaction = new WithdrawTransaction(generateTransactionId(), account, amount);
        try {
            cashDispenser.dispenseCash(amount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        bankingService.processTransaction(transaction);
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
