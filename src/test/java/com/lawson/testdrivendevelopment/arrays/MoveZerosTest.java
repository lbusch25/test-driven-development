package com.lawson.testdrivendevelopment.arrays;

import org.junit.Assert;
import org.junit.Test;

public class MoveZerosTest {

    @Test
    public void moveZeroes_When_CorrectInput_Expect_ZeroesAtEnd() {
        int[] nums = new int[]{0,1,0,3,12};
        MoveZeros.moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{1,3,12,0,0}, nums);
    }

    @Test
    public void moveZeroes_When_SingleElement_Expect_ZeroesAtEnd() {
        int[] nums = new int[]{0};
        MoveZeros.moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{0}, nums);
    }

    @Test
    public void moveZeroes_When_SingleNonZeroElement_Expect_ZeroesAtEnd() {
        int[] nums = new int[]{1};
        MoveZeros.moveZeroes(nums);
        Assert.assertArrayEquals(new int[]{1}, nums);
    }
}
