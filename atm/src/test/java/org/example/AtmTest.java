package org.example;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.data.Offset.offset;


public class AtmTest {

    private final Atm atm = new Atm();

    @Test
    public void whenWithdrawNegativeAmount_thenException() {
        // WHEN
        Assertions.assertThatThrownBy(() -> atm.withdraw(-10, 120.0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Amount to withdraw must be greater than");
    }

    @Test
    public void whenWithdrawAmountGreaterThan2000_thenException() {
        // WHEN
        Assertions.assertThatThrownBy(() -> atm.withdraw(2001, 120.0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Amount to withdraw must be less than");
    }

    @Test
    public void whenWithdrawAmountIsNotAMultipleOf5_thenReturnInitialAmount() {
        // WHEN
        Assertions.assertThat(atm.withdraw(42, 120.0))
                .isEqualTo(120.0, offset(0.1));
    }

    @Test
    public void whenInsufficientFunds_thenReturnInitialAmount() {
        // WHEN
        Assertions.assertThat(atm.withdraw(300, 120.0))
                .isEqualTo(120.0, offset(0.1));
    }

    @Test
    public void whenAmountIsAMultipleOf5AndFundsAreSufficient_thenReturnsInitialAmountMinusAskedAmountAndFees() {
        // WHEN
        Assertions.assertThat(atm.withdraw(30, 120.0))
                .isEqualTo(89.5, offset(0.1));
    }
}
