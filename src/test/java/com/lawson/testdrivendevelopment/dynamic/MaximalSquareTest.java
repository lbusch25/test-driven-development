package com.lawson.testdrivendevelopment.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximalSquareTest {

    @Test
    void maximalSquare_1() {
        char[][] matrix = {{'1','0','1','0','0'},
                           {'1','0','1','1','1'},
                           {'1','1','1','1','1'},
                           {'1','0','0','1','0'}};
        Assertions.assertEquals(4, MaximalSquare.maximalSquare(matrix));
    }

    @Test
    void maximalSquare_4() {
        char[][] matrix =  {{'1','1','1','0','0'},
                            {'1','1','1','1','1'},
                            {'1','1','1','1','1'},
                            {'1','0','0','1','0'}};
        Assertions.assertEquals(9, MaximalSquare.maximalSquare(matrix));
    }

    @Test
    void maximalSquare_2() {
        char[][] matrix = {{'0','1'},{'1','0'}};
        Assertions.assertEquals(1, MaximalSquare.maximalSquare(matrix));
    }

    @Test
    void maximalSquare_3() {
        char[][] matrix = {{'0'}};
        Assertions.assertEquals(0, MaximalSquare.maximalSquare(matrix));
    }

    @Test
    void maximalSquare_5() {
        char[][] matrix =  {{'1','1','1','0','0'},
                            {'1','1','1','0','1'},
                            {'1','1','1','1','1'},
                            {'1','0','0','1','1'}};
        Assertions.assertEquals(9, MaximalSquare.maximalSquare(matrix));
    }

    @Test
    void maximalSquare_6() {
        char[][] matrix =  {{'1','1','1','1','0'},
                            {'1','1','1','1','0'},
                            {'1','1','1','1','1'},
                            {'1','1','1','1','1'},
                            {'0','0','1','1','1'}};
        Assertions.assertEquals(16, MaximalSquare.maximalSquare(matrix));
    }
}
