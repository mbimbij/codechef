package org.example;

import org.junit.jupiter.api.Test;

public class SumSquareDifference {
    @Test
    void sum_square_difference_test() {
        long sumOfSquares = 0;
        long squareOfSums = 0;
        for (int i = 1; i <= 100; i++) {
            sumOfSquares += i * i;
            squareOfSums += i;
        }
        squareOfSums *= squareOfSums;

        System.out.println("sumOfSquares: " + sumOfSquares);
        System.out.println("squareOfSums: " + squareOfSums);
        System.out.println("difference: " + (squareOfSums - sumOfSquares));
    }
}
