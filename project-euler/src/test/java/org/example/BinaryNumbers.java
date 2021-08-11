package org.example;

import org.junit.jupiter.api.Test;

public class BinaryNumbers {
    @Test
    void name() {
        int nb = 0;
        nb |= (1 << 5);
        nb |= (1 << 2);
        nb |= 1;
        nb &= ~(1 << 5);
        System.out.println(nb);
//        System.out.println(Integer.toBinaryString());
    }
}
