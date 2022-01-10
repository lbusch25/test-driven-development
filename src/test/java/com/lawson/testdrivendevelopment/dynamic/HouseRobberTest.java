package com.lawson.testdrivendevelopment.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HouseRobberTest {

    @Test
    void house_robber_1() {
        int[] nums = new int[]{1, 2, 3, 1};
        Assertions.assertEquals(4, HouseRobber.rob(nums));
    }

    @Test
    void house_robber_2() {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        Assertions.assertEquals(12, HouseRobber.rob(nums));
    }
}
