package com.lawson.testdrivendevelopment.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void tribonacci_4() {
        int n = 4;
        Assertions.assertEquals(4, Fibonacci.tribonacci(n));
    }

    @Test
    void tribonacci_25() {
        int n = 25;
        Assertions.assertEquals(1389537, Fibonacci.tribonacci(n));
    }
}
