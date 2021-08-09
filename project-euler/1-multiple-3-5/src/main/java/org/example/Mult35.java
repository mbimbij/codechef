package org.example;

import java.util.stream.LongStream;

public class Mult35 {
    public long computeSum(int max) {
        return LongStream.range(1, max + 1)
                .filter(i -> i % 3 == 0 || i % 5 == 0)
                .sum();
    }

    public long[] getAllMults(int max){
        return LongStream.range(1, max + 1)
                .filter(i -> i % 3 == 0 || i % 5 == 0)
                .toArray();
    }
}
