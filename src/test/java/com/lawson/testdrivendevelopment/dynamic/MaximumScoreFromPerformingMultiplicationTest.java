package com.lawson.testdrivendevelopment.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumScoreFromPerformingMultiplicationTest {

    @Test
    void maximumScore_1() {
        MaximumScoreFromMultiplication m = new MaximumScoreFromMultiplication();
        var nums = new int[]{1,2,3};
        var multipliers = new int[]{3,2,1};
        Assertions.assertEquals(14, m.maximumScore(nums, multipliers));
    }

    @Test
    void maximumScore_2() {
        MaximumScoreFromMultiplication m = new MaximumScoreFromMultiplication();
        var nums = new int[]{-5,-3,-3,-2,7,1};
        var multipliers = new int[]{-10,-5,3,4,6};
        Assertions.assertEquals(102, m.maximumScore(nums, multipliers));
    }
}
