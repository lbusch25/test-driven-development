package com.lawson.testdrivendevelopment.search.breadthdepth;

import org.junit.Assert;
import org.junit.Test;

public class MaxIslandAreaTest {

    @Test
    public void test_maxAreaOfIsland_When_islands_Expect_CorrectArea() {
        int[][] image = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                         {0,0,0,0,0,0,0,1,1,1,0,0,0},
                         {0,1,1,0,1,0,0,0,0,0,0,0,0},
                         {0,1,0,0,1,1,0,0,1,0,1,0,0},
                         {0,1,0,0,1,1,0,0,1,1,1,0,0},
                         {0,0,0,0,0,0,0,0,0,0,1,0,0},
                         {0,0,0,0,0,0,0,1,1,1,0,0,0},
                         {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int result = 6;
        Assert.assertEquals(result, MaxIslandArea.maxAreaOfIsland(image));
    }

    @Test
    public void test_maxAreaOfIsland_When_empty_Expect_Zero() {
        int[][] image = {{0,0,0,0,0,0,0,0}};
        int result = 0;
        Assert.assertEquals(result, MaxIslandArea.maxAreaOfIsland(image));
    }
}
