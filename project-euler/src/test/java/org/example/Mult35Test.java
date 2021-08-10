package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Mult35Test {
    @Test
    void mult35Test() {
        Mult35 mult35 = new Mult35();
        System.out.println("v1: " + mult35.computeSum(999));
//        System.out.println("all mults: " + Arrays.toString(mult35.getAllMults(100)));
    }
}
