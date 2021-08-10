package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _9_SpecialPythagoreanTriplet {
    @Test
    void _9_special_pythagorean_triplet() {
        int[][] ints = generateTriplesSumEquals1000();
        assert ints.length == 1;
        int product = Arrays.stream(ints[0]).reduce((ints1, ints2) -> ints1 * ints2).orElseThrow();
        System.out.println(product);
        System.out.println(Arrays.toString(ints[0]));
    }

    private int[][] generateTriplesSumEquals1000() {
        List<int[]> validTuples = new ArrayList<>();
        for (int i = 0; i < 998; i++) {
            for (int j = 0; j < 998; j++) {
                for (int k = 0; k < 998; k++) {
                    if ((i < j) && (j < k) && (i + j + k == 1000) && (i * i + j * j == k * k)) {
                        validTuples.add(new int[]{i, j, k});
                    }
                }
            }
        }
        return validTuples.toArray(new int[0][]);
    }
}
