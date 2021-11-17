package com.lawson.testdrivendevelopment.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {

    /**
     *
     * @param s input string
     * @return length of longest substring without repeating characters
     */
    public static int lengthOfLongestSubstring(String s) {
        return slidingWindow(s);
    }

    /**
     * An O(N^2) solution - brute force
     *
     * Actually - this is an O(N) solution because we are starting at j = i
     * That => that for each index, j and i will in the worst case 2n times
     * now this can be improved by checking trailing characters instead of leading
     * characters - but I'm going to improve it even more in the slidingwindow solution
     *
     * Note: this always hits the worst case of 2i and 2j - if I checked trailing instead
     * of leading we could avoid repeat checks of i and j in most cases (non repeating characters)
     *
     * @param s input string
     * @return length of longest substring without repeating characters
     */
    private static int bruteForce(String s) {
        int length = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Set<Character> seen = new HashSet<>();
            // can optimize with a two pointer approach and keeping track of how many we've seen
            for (int j = i; j < chars.length; j++) {
                if (seen.contains(chars[j])) {
                    break;
                } else {
                    seen.add(chars[j]);
                }
            }
            length = Math.max(seen.size(), length);
        }
        return length;
    }


    /**
     * By using a map to keep track of the position we can solve this in O(n) time
     * with each pointer only visiting once!
     *
     * @param s
     * @return length of longest substring
     */
    private static int slidingWindow(String s) {
        int length = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            length = Math.max((j - i) + 1, length);
            map.put(s.charAt(j), j + 1);
        }
        return length;
    }
}
