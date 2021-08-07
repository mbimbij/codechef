package org.example;

public class Atm {

    private int withdrawUpperLimit = 2000;
    private int withdrawLowerLimit = 0;
    private double fees = 0.5;

    public double withdraw(int amountToWithdraw, double initialAccountBalance) {
        if (amountToWithdraw <= withdrawLowerLimit) {
            throw new IllegalArgumentException("Amount to withdraw must be greater than "+withdrawLowerLimit+", but got: " + amountToWithdraw);
        }
        if (amountToWithdraw > withdrawUpperLimit) {
            throw new IllegalArgumentException("Amount to withdraw must be less than "+withdrawUpperLimit+", but got: " + amountToWithdraw);
        }
        if(notAMultipleOf5(amountToWithdraw) || insufficientFunds(amountToWithdraw, initialAccountBalance)){
            return initialAccountBalance;
        }
        return initialAccountBalance - amountToWithdraw - fees;
    }

    private boolean insufficientFunds(int amountToWithdraw, double initialAccountBalance) {
        return amountToWithdraw > initialAccountBalance;
    }

    private boolean notAMultipleOf5(int amountToWithdraw) {
        return amountToWithdraw % 5 != 0;
    }
}
