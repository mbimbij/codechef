package org.example.fibonacci;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class FibonacciMemoizedTest {
    @Test
    void fiboUnmemoized() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(Fibonacci.computeUnmemoized(0)).isEqualTo(0);
            softAssertions.assertThat(Fibonacci.computeUnmemoized(1)).isEqualTo(1);
            softAssertions.assertThat(Fibonacci.computeUnmemoized(2)).isEqualTo(1);
            softAssertions.assertThat(Fibonacci.computeUnmemoized(3)).isEqualTo(2);
            softAssertions.assertThat(Fibonacci.computeUnmemoized(4)).isEqualTo(3);
            softAssertions.assertThat(Fibonacci.computeUnmemoized(5)).isEqualTo(5);
            softAssertions.assertThat(Fibonacci.computeUnmemoized(6)).isEqualTo(8);
        });
    }

    @Test
    void fiboMemoized() {
        System.out.println(Fibonacci.computeMemoized(10));
    }
}
