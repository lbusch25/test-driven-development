package com.lawson.testdrivendevelopment.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClimbingStairsTest {

    @Test
    void climbingStairs_2() {
        int n = 2;
        Assertions.assertEquals(2, ClimbingStairs.climbStairs(n));
    }

    @Test
    void climbingStairs_3() {
        int n = 3;
        Assertions.assertEquals(3, ClimbingStairs.climbStairs(n));
    }

    @Test
    void climbingStairs_4() {
        int n = 4;
        Assertions.assertEquals(5, ClimbingStairs.climbStairs(n));
    }

    @Test
    void climbingStairs_5() {
        int n = 5;
        Assertions.assertEquals(8, ClimbingStairs.climbStairs(n));
    }

    @Test
    void minClimbingStairs_1() {
        int[] cost = new int[]{10, 15, 20};
        Assertions.assertEquals(15, ClimbingStairs.minCostClimbingStairs(cost));
    }

    @Test
    void minClimbingStairs_2() {
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};
        Assertions.assertEquals(6, ClimbingStairs.minCostClimbingStairs(cost));
    }
}
