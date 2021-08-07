package org.example;

public class Atm {
    public double withdraw(int amountToWithdraw) {
        if (amountToWithdraw <= 0) {
            throw new IllegalArgumentException("Amount to withdraw must be strictly positive, but got: " + amountToWithdraw);
        }
        return 0;
    }
}
