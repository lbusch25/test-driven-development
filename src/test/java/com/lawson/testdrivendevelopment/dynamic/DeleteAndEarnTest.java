package com.lawson.testdrivendevelopment.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeleteAndEarnTest {

    @Test
    void deleteAndEarn_1() {
        int[] nums = new int[]{3,4,2};
        Assertions.assertEquals(6, DeleteAndEarn.deleteAndEarn(nums));
    }

    @Test
    void deleteAndEarn_2() {
        int[] nums = new int[]{2,2,3,3,3,4};
        Assertions.assertEquals(9, DeleteAndEarn.deleteAndEarn(nums));
    }
}
