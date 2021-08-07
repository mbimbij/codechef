package org.example;

public class Atm {

    private int withdrawUpperLimit = 2000;
    private int withdrawLowerLimit = 0;

    public double withdraw(int amountToWithdraw, double initialAccountBalance) {
        if (amountToWithdraw <= withdrawLowerLimit) {
            throw new IllegalArgumentException("Amount to withdraw must be greater than "+withdrawLowerLimit+", but got: " + amountToWithdraw);
        }
        if (amountToWithdraw > withdrawUpperLimit) {
            throw new IllegalArgumentException("Amount to withdraw must be less than "+withdrawUpperLimit+", but got: " + amountToWithdraw);
        }
        return initialAccountBalance;
    }
}
