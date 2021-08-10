package org.example;

import io.vavr.Tuple2;
import io.vavr.collection.Stream;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public class _10_SummationOfPrimes {

    @Test
    void _10_summation_of_primes() {
        Integer[] integers = eratosthenesSieve(2_000_000);
        System.out.println(Arrays.stream(integers).mapToLong(Integer::longValue).reduce(Long::sum).orElseThrow());
    }

    public Integer[] eratosthenesSieve(int n) {
        Boolean[] a = new Boolean[n];
        Arrays.fill(a, true);
        a[0] = a[1] = false;
        for (int i = 2; i < sqrt(n); i++) {
            if (a[i]) {
                for (int j = i * i; j < n; j += i) {
                    a[j] = false;
                }
            }
        }
        return Stream.of(a)
                .zipWithIndex()
                .filter(Tuple2::_1)
                .map(Tuple2::_2)
                .toJavaArray(Integer[]::new);
    }
}
