package com.lawson.testdrivendevelopment.strings;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringTest {

    @Test
    public void lengthOfLongestSubstring_abcabcbb() {
        String s = "abcabcbb";
        int expected = 3;
        Assert.assertEquals(expected, LongestSubstring.lengthOfLongestSubstring(s));
    }

    @Test
    public void lengthOfLongestSubstring_bbbbb() {
        String s = "bbbbb";
        int expected = 1;
        Assert.assertEquals(expected, LongestSubstring.lengthOfLongestSubstring(s));
    }

    @Test
    public void lengthOfLongestSubstring_pwwkew() {
        String s = "pwwkew";
        int expected = 3;
        Assert.assertEquals(expected, LongestSubstring.lengthOfLongestSubstring(s));
    }

    @Test
    public void lengthOfLongestSubstring_empty() {
        String s = "";
        int expected = 0;
        Assert.assertEquals(expected, LongestSubstring.lengthOfLongestSubstring(s));
    }
}
