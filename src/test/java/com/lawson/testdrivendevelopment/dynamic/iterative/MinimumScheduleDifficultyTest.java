package com.lawson.testdrivendevelopment.dynamic.iterative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumScheduleDifficultyTest {

    @Test
    void minDifficulty_1() {
        var jobs = new int[]{6,5,4,3,2,1};
        var days = 2;
        Assertions.assertEquals(7, MinimumScheduleDifficulty.minDifficulty(jobs, days));
    }

    @Test
    void minDifficulty_2() {
        var jobs = new int[]{9,9,9};
        var days = 4;
        Assertions.assertEquals(-1, MinimumScheduleDifficulty.minDifficulty(jobs, days));
    }

    @Test
    void minDifficulty_3() {
        var jobs = new int[]{1,1,1};
        var days = 3;
        Assertions.assertEquals(3, MinimumScheduleDifficulty.minDifficulty(jobs, days));
    }
}
