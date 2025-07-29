package model;

import service.AccountService;

public class CurrentAccount extends Account {
    private double specialBalance;
    private static long accountNumber = 1231000;

    public CurrentAccount(double balance, AccountService service) {
        super(accountNumber++, balance, service);
        this.specialBalance = getService().calculateSpecialBalance(this.getAccountBalance());
    }

    @Override
    public void depositValue(double value) {
        super.depositValue(value);
        this.specialBalance = getService().calculateSpecialBalance(this.getAccountBalance());
    }

    @Override
    public void withdrawValue(double value) {
        super.withdrawValue(getService().calculateWithdrawFee(value));
        this.specialBalance = getService().calculateSpecialBalance(this.getAccountBalance());
    }

    @Override
    public void transferValue(double value, Account account) {
        super.transferValue(value, account);
        this.specialBalance = getService().calculateSpecialBalance(this.getAccountBalance());
    }

    @Override
    public String toString() {
        double totalBalance = this.getAccountBalance() + specialBalance;
        return "[Current] " + "Agency: " + this.getAgencyNumber() +
                " - Account: " + this.getAccountNumber() +
                " | Balance: " + String.format("R$ %.2f", totalBalance) +
                String.format(" (Special: R$ %.2f)", specialBalance);
    }
}
