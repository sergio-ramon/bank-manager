package application;

import model.Bank;
import service.NubankService;

public class BankManagerTest {
    public static void main(String[] args) {

        Bank bank = new Bank("Nubank", new NubankService());

        bank.addCurrentAccount(500);
        bank.addSavingsAccount(0);

        bank.getAccounts().getFirst().transferValue(100, bank.getAccounts().getLast());
        bank.getAccounts().getFirst().transferValue(100, bank.getAccounts().getLast());
        bank.getAccounts().getFirst().transferValue(100, bank.getAccounts().getLast());
        bank.getAccounts().getFirst().transferValue(100, bank.getAccounts().getLast());

        bank.getAccounts().getFirst().depositValue(200);
        bank.getAccounts().getLast().depositValue(200);

        System.out.println(bank.getAccounts().getFirst().getExtract());
        System.out.println(bank.getAccounts().getLast().getExtract());

    }
}
