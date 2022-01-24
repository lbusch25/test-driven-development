package com.lawson.testdrivendevelopment.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestCommonSubsequenceTest {

    @Test
    void longestSubsequence_1() {
        var text1 = "abcde";
        var text2 = "ace";
        Assertions.assertEquals(3, LongestCommonSubsequence.longestCommonSubsequence(text1, text2));
    }

    @Test
    void longestSubsequence_2() {
        var text1 = "abc";
        var text2 = "abc";
        Assertions.assertEquals(3, LongestCommonSubsequence.longestCommonSubsequence(text1, text2));
    }

    @Test
    void longestSubsequence_3() {
        var text1 = "abc";
        var text2 = "def";
        Assertions.assertEquals(0, LongestCommonSubsequence.longestCommonSubsequence(text1, text2));
    }

    @Test
    void longestSubsequence_4() {
        var text1 = "ace";
        var text2 = "abcde";
        Assertions.assertEquals(3, LongestCommonSubsequence.longestCommonSubsequence(text1, text2));
    }
}
