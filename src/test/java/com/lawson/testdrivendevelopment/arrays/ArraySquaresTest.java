package com.lawson.testdrivendevelopment.arrays;

import org.junit.Assert;
import org.junit.Test;

public class ArraySquaresTest {

    @Test
    public void basicApproach_When_negatives_shouldSortCorrectly() {
        int[] nums = new int[]{-4,-1,0,3,10};
        int[] res = new int[]{0,1,9,16,100};
        Assert.assertArrayEquals(res, ArraySquares.sortedSquares(nums));
    }

    @Test
    public void linearApproach_When_AllNegativeArray_shouldSortCorrectly() {
        int[] nums = new int[]{-5,-3,-2,-1};
        int[] res = new int[]{1,4,9,25};
        Assert.assertArrayEquals(res, ArraySquares.sortedSquares(nums));
    }
}
