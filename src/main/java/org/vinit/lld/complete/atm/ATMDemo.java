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
        ATM atm = new ATM(bankingService, cashDispenser);

        bankingService.createAccount("12345", 10000D);
        bankingService.createAccount("23456", 4000D);
        bankingService.createAccount("34567", 500D);

        Card card1 = new Card("123456789", "1234");
        Card card2 = new Card("987654321", "3000");

//        atm.authenticateCard(card1);
        atm.withdrawCash("23456", 2500D);
        atm.withdrawCash("23456", 2500D);
        atm.withdrawCash("12345", 10000D);

        System.out.println("\n\n--------------------------------------------------------");
        System.out.println("\t\t\t*** ENDING ATM EXECUTION ***");
        System.out.println("--------------------------------------------------------");
    }
}
