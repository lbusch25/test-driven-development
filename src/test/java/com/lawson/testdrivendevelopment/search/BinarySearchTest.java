package com.lawson.testdrivendevelopment.search;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void search_When_9_Present_returns_4() {
        int[] nums  = new int[]{-1,0,3,5,9,12};
        int target = 9;
        Assert.assertEquals(4, BinarySearch.search(nums, target));
    }

    @Test
    public void search_When_NotPresent_returns_Neg1() {
        int[] nums  = new int[]{-1,0,3,5,9,12};
        int target = 2;
        Assert.assertEquals(-1, BinarySearch.search(nums, target));
    }

    @Test
    public void search_When_OnlyOne_returns_0() {
        int[] nums  = new int[]{5};
        int target = 5;
        Assert.assertEquals(0, BinarySearch.search(nums, target));
    }

    @Test
    public void search_When_CorrectIndex_returns_Neg1() {
        int[] nums  = new int[]{-1,0,3,5,9,12};
        int target = 13;
        Assert.assertEquals(-1, BinarySearch.search(nums, target));
    }
}
