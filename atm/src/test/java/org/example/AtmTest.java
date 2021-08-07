package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class AtmTest {
    @Test
    public void whenWithdrawNegativeAmount_thenException() {
        // GIVEN
        Atm atm = new Atm();

        // WHEN
        Assertions.assertThatThrownBy(() -> atm.withdraw(-10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Amount to withdraw must be greater than");
    }

    @Test
    public void whenWithdrawAmountGreaterThan2000_thenException() {
        // GIVEN
        Atm atm = new Atm();

        // WHEN
        Assertions.assertThatThrownBy(() -> atm.withdraw(2001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Amount to withdraw must be less than");
    }
}
