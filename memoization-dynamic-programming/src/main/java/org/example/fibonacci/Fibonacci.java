package org.example.fibonacci;

import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci {
    public static long computeUnmemoized(int i) {
        System.out.println("calling computeUnmemoized: " + i);
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return computeUnmemoized(i - 1) + computeUnmemoized(i - 2);
    }

    private static ArrayList<Long> memo = new ArrayList<>(Arrays.asList(0L, 1L));

    public static long computeMemoized(int i) {
        if (memo.size() <= i) {
            System.out.println("compute un-memoized: " + i);
            memo.add(i, computeMemoized(i - 1) + computeMemoized(i - 2));
        }
        System.out.println("memoized: " + i);
        return memo.get(i);
    }
}
