package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class AtmTest {

    private final Atm atm = new Atm();

    @Test
    public void whenWithdrawNegativeAmount_thenException() {
        // WHEN
        Assertions.assertThatThrownBy(() -> atm.withdraw(-10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Amount to withdraw must be greater than");
    }

    @Test
    public void whenWithdrawAmountGreaterThan2000_thenException() {
        // WHEN
        Assertions.assertThatThrownBy(() -> atm.withdraw(2001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Amount to withdraw must be less than");
    }
}
