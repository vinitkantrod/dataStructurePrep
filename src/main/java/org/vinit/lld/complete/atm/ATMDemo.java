package org.vinit.lld.complete.atm;

/**
 * Entities:
 * Account (accNumber, balance, name)
 * Card (card_number, pin)
 * Cash Dispenser (balance)
 * Banking Service ()
 * ATM ()
 */
public class ATMDemo {
    public static void run() {
        System.out.println("\n--------------------------------------------------------");
        System.out.println("\t\t\t*** STARTING ATM EXECUTION ***");
        System.out.println("--------------------------------------------------------\n\n");
        BankingService bankingService = new BankingService();
        CashDispenser cashDispenser = new CashDispenser(50000D);

        bankingService.createAccount("12345", 10000D);
        bankingService.createAccount("23456", 4000D);
        bankingService.createAccount("34567", 500D);

        System.out.println("\n\n--------------------------------------------------------");
        System.out.println("\t\t\t*** ENDING ATM EXECUTION ***");
        System.out.println("--------------------------------------------------------");
    }
}
