package service;

public class NubankService implements AccountService {
    @Override
    public double calculateSpecialBalance(double balance) {
        float specialBalanceFee = 0.20f;
        return (balance * 1) * specialBalanceFee;
    }

    @Override
    public double calculateWithdrawFee(double value) {
        float withdrawFee = 0.02f;
        return (value) + value * withdrawFee;
    }

    public double calculateSavingsFee(double value) {
        float savingsFee = 0.001f;
        return (value) + value * savingsFee;
    }
}
