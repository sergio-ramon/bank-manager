package model;

import service.AccountService;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private List<Account> accounts = new ArrayList<>();
    private AccountService service;

    public Bank(String bankName, AccountService service) {
        this.bankName = bankName;
        this.service = service;
    }

    public void addCurrentAccount(double balance) {
        accounts.add(new CurrentAccount(balance, service));
    }

    public void addSavingsAccount(double balance) {
        accounts.add(new SavingsAccount(balance, service));
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getBankName() {
        return bankName;
    }
}
