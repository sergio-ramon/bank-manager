package model;

import service.AccountService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public abstract class Account implements Comparable<Account> {
    private int agencyNumber = 123;
    private long accountNumber;
    protected double accountBalance;
    private AccountService service;
    private StringBuilder extract = new StringBuilder();

    public Account(long account, double balance, AccountService service) {
        this.accountNumber = account;
        this.accountBalance = balance;
        this.service = service;
        appendExtract("entry deposit", balance);
    }

    public void depositValue(double value) {
        this.accountBalance += value;
        appendExtract("deposit", value);
    }

    protected void receiveValue(double value) {
        this.accountBalance += value;
        appendExtract("received transference", value);
    }

    public void transferValue(double value, Account account) {
        if (value > 0 && value <= accountBalance) {
            accountBalance -= value;
            account.receiveValue(value);
            this.appendExtract("transference", value);
        }
    }

    public void withdrawValue(double value) {
        if (value > 0 && value <= accountBalance) {
            accountBalance -= value;
            appendExtract("withdraw", value);
        }
    }

    public String getExtract() {
        return "+=================================================================================\n" +
                "| " + this + "\n" +
                "+--------------------------------------------------------------------------------\n" +
                extract +
                "\n+=================================================================================";
    }

    @Override
    public int compareTo(Account acc) {
        return Long.compare(accountNumber, acc.getAccountNumber());
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public int getAgencyNumber() {
        return agencyNumber;
    }

    public AccountService getService() {
        return service;
    }

    protected void appendExtract(String operation, double value) {
        if (!extract.isEmpty()) extract.append("\n");

        extract.append("| ")
                .append(LocalDate.now()).append(" ")
                .append(LocalTime.now().truncatedTo(ChronoUnit.SECONDS))
                .append(" R$ ")
                .append(String.format("%.2f", value)).append(" ")
                .append(operation);
    }
}
