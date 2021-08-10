package org.example;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class SmallestMultiple {
    @Test
    void smallest_multiple_test() {
        int i = 1;
        while (!isEvenlyDivisibleByAllNbFrom1ToM(i, 20)) {
            i++;
        }
        System.out.println(i);
    }

    private boolean isEvenlyDivisibleByAllNbFrom1ToM(long n, int m) {
       return IntStream.rangeClosed(1, m)
                .allMatch(i -> n % i == 0);
    }

    @Test
    void name() {
        System.out.println(7 % 3);
    }
}
