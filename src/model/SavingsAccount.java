package model;

import service.AccountService;

public class SavingsAccount extends Account {
    private static long accountNumber = 1232000;

    public SavingsAccount(double balance, AccountService service) {
        super(accountNumber++, balance, service);
    }

    @Override
    public void depositValue(double value) {
        this.accountBalance += (this.getService().calculateSavingsFee(value));
        this.appendExtract("deposit", value);
    }

    @Override
    protected void receiveValue(double value) {
        this.accountBalance += (this.getService().calculateSavingsFee(value));
        this.appendExtract("received transference", value);
    }

    @Override
    public String toString() {
        return "[Savings] " + "Agency: " + getAgencyNumber() +
                " - Account: " + getAccountNumber() +
                " | Balance: " + String.format("R$ %.2f", getAccountBalance());
    }
}
