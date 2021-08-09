package org.example;

import org.junit.jupiter.api.Test;

import java.util.Objects;

public class LargestPalindromeProduct {
    @Test
    void test() {
        System.out.println(findMaxPalindrome());
    }


    long findMaxPalindrome() {
        long max = 0;
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                long product = i * j;
                if (isPalindrome(product) && product > max) {
                    max = product;
                }
            }
        }
        return max;
    }

    boolean isPalindrome(Number n) {
        String string = String.valueOf(n);
        String reverseString = new StringBuilder(string).reverse().toString();
        return Objects.equals(string, reverseString);
    }
}
