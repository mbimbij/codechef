package org.example;

import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

public class _10001stPrime {

    @Test
    void _10001_st_prime() {
        System.out.println(getNthPrime(10001));
    }

    public long getNthPrime(int n) {
        long nbCpt = 0;
        int primeCpt = 0;
        while (primeCpt <= n) {
            nbCpt++;
            if (isPrime(nbCpt)) {
                primeCpt++;
            }
        }
        return nbCpt;
    }

    private boolean isPrime(long nbCpt) {
        return nbCpt == 1 || nbCpt == 2 || LongStream.rangeClosed(2, nbCpt-1).noneMatch(l -> nbCpt % l == 0);
    }
}
