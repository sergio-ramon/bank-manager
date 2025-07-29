package service;

public interface AccountService {
    double calculateSpecialBalance(double balance);
    double calculateWithdrawFee(double value);
    double calculateSavingsFee(double value);
}
