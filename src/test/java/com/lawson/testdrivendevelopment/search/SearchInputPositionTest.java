package com.lawson.testdrivendevelopment.search;

import org.junit.Assert;
import org.junit.Test;

public class SearchInputPositionTest {

    @Test
    public void search_When_5_Present_returns_2() {
        int[] nums  = new int[]{1,3,5,6};
        int target = 5;
        Assert.assertEquals(2, SearchInputPosition.searchInsert(nums, target));
    }

    @Test
    public void search_When_NotPresent_returns_Insert2() {
        int[] nums  = new int[]{1,3,5,6};
        int target = 2;
        Assert.assertEquals(1, SearchInputPosition.searchInsert(nums, target));
    }

    @Test
    public void search_When_NotPresent_returns_Insert0() {
        int[] nums  = new int[]{1,3,5,6};
        int target = 0;
        Assert.assertEquals(0, SearchInputPosition.searchInsert(nums, target));
    }

    @Test
    public void search_When_Only1_returns_Insert0() {
        int[] nums  = new int[]{1};
        int target = 0;
        Assert.assertEquals(0, SearchInputPosition.searchInsert(nums, target));
    }

    @Test
    public void search_When_Only1_returns_0() {
        int[] nums  = new int[]{1};
        int target = 1;
        Assert.assertEquals(0, SearchInputPosition.searchInsert(nums, target));
    }
}
