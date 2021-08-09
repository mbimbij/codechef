package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EvenFibonacciNumbersTest {
    @Test
    void name() {
        long limit = 4_000_000 - 1;
        System.out.println(sumEvenFibo(limit));
    }

    List<Long> memo = new ArrayList<>();

    @BeforeEach
    void setUp() {
        memo.add(0L);
        memo.add(1L);
    }

    public long fibo(int n) {
        if (memo.size() <= n) {
            memo.add(n, fibo(n - 1) + fibo(n - 2));
        }
        return memo.get(n);
    }

    public long sumEvenFibo(long limit) {
        long sum = 0;
        int cpt = 0;
        long fibo = fibo(cpt);
        while (fibo <= limit) {
            if (fibo % 2 == 0) {
                sum += fibo;
            }
            cpt++;
            fibo = fibo(cpt);
        }
        return sum;
    }
}
