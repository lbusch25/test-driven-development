package com.lawson.testdrivendevelopment.arrays;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

    @Test
    public void twoSum_Should_FindFactors() {
        int[] nums = new int[]{-1,0};
        int target = -1;
        Assert.assertArrayEquals(new int[]{0,1}, TwoSum.twoSum(nums, target));
    }

    @Test
    public void twoSum_Should_FindFactors1() {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        Assert.assertArrayEquals(new int[]{0,1}, TwoSum.twoSum(nums, target));
    }
}
