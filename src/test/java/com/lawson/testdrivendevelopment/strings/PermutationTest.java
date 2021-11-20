package com.lawson.testdrivendevelopment.strings;

import org.junit.Assert;
import org.junit.Test;

public class PermutationTest {

    @Test
    public void checkInclusion_shouldReturnTrue() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        Assert.assertTrue(Permutation.checkInclusion(s1, s2));
    }

    @Test
    public void checkInclusion_shouldReturnFalse() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        Assert.assertFalse(Permutation.checkInclusion(s1, s2));
    }
}
