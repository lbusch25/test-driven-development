package com.lawson.testdrivendevelopment.search.breadthdepth;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FloodFillTest {

    @Test
    public void test_floodFill_1() {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] result = {{2,2,2},{2,2,0},{2,0,1}};
        Assert.assertTrue(Arrays.deepEquals(result, FloodFill.floodFill(image, 1, 1, 2)));
    }
}
