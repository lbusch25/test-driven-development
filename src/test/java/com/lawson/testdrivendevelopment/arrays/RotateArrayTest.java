package com.lawson.testdrivendevelopment.arrays;

import org.junit.Assert;
import org.junit.Test;

public class RotateArrayTest {

    @Test
    public void rotateArray_When_OneStep_rotatesCorrectly() {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        RotateArray.rotate(nums, 1);
        Assert.assertArrayEquals(new int[]{7,1,2,3,4,5,6}, nums);
    }

    @Test
    public void rotateArray_When_TwoStep_rotatesCorrectly() {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        RotateArray.rotate(nums, 2);
        Assert.assertArrayEquals(new int[]{6,7,1,2,3,4,5}, nums);
    }

    @Test
    public void rotateArray_When_ThreeStep_rotatesCorrectly() {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        RotateArray.rotate(nums, 3);
        Assert.assertArrayEquals(new int[]{5,6,7,1,2,3,4}, nums);
    }

    @Test
    public void rotateArray_When_EightStep_rotatesOneStep() {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        RotateArray.rotate(nums, 8);
        Assert.assertArrayEquals(new int[]{7,1,2,3,4,5,6}, nums);
    }

    @Test
    public void rotateArray_When_Length_NoRotate() {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        RotateArray.rotate(nums, nums.length);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7}, nums);
    }

    @Test
    public void rotateArray_When_0_NoRotate() {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        RotateArray.rotate(nums, 0);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7}, nums);
    }
}
