package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestPrimeFactorTest {
    @Test
    void largest_prime_factor_test() {
        List<int[]> primeFactors = primeFactorization(600851475143L);
        primeFactors.forEach(ints -> System.out.println(Arrays.toString(ints)));
    }

    public List<int[]> primeFactorization(long n) {
        List<int[]> retVal = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                int cpt = 0;
                while (n % i == 0) {
                    n /= i;
                    cpt++;
                }
                retVal.add(new int[]{i, cpt});
            }
        }
        return retVal;
    }
}
