package com.lawson.testdrivendevelopment.search.breadthdepth;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class BinaryMatrixDistanceTest {

    @Test
    public void test_updateMatrix_1() {
        int[][] image = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] result = {{0,0,0},{0,1,0},{0,0,0}};
        Assert.assertTrue(Arrays.deepEquals(result, BinaryMatrixDistance.updateMatrix(image)));
    }

    @Test
    public void test_updateMatrix_2() {
        int[][] image = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] result = {{0,0,0},{0,1,0},{1,2,1}};
        int[][] calc = BinaryMatrixDistance.updateMatrix(image);
        Assert.assertTrue(Arrays.deepEquals(result, calc));
    }
}
