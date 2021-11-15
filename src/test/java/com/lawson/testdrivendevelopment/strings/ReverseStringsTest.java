package com.lawson.testdrivendevelopment.strings;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringsTest {

    @Test
    public void reverseString_should_reverse() {
        char[] s = new char[]{'h','e','l','l','o'};
        Reverse.reverseString(s);
        Assert.assertArrayEquals(new char[]{'o','l','l','e','h'}, s);
    }

    @Test
    public void reverseString_When_odd_Expect_Reverse() {
        char[] s = new char[]{'h','e','l','l','o','o'};
        Reverse.reverseString(s);
        Assert.assertArrayEquals(new char[]{'o','o','l','l','e','h'}, s);
    }

    @Test
    public void reverseWords_should_reverse() {
        String s = "Let's take LeetCode contest";
        String expected = "s'teL ekat edoCteeL tsetnoc";
        Assert.assertEquals(expected, Reverse.reverseWords(s));
    }

    @Test
    public void reverseWords_should_reverse1() {
        String s = "God Ding";
        String expected = "doG gniD";
        Assert.assertEquals(expected, Reverse.reverseWords(s));
    }
}
