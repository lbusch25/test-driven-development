package com.lawson.testdrivendevelopment.strings;

import java.util.HashMap;
import java.util.Map;

public class Permutation {

    public static boolean checkInclusion(String s1, String s2) {
        return slidingWindow(s1, s2);
    }

    /**
     *
     * Really what we care about is the number of characters
     * IE is there a consecutive substring that contains the
     * exact characters of s1
     *
     * @param s1 the permutation string
     * @param s2 the string that may contain s1
     * @return if s2 contains s1
     */
    private static boolean firstAttempt(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> perms = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            perms.merge(c, 1, Integer::sum);
        }
        /*
         * We can use two pointers here for the start and end of the string
         * if we exceed the length of s1, find a character outside s1,
         * or too many characters in s1 we can set i = j
         */
        int i = 0;
        while (i < s2.length() && s2.length() - i > s1.length()) {
            HashMap<Character, Integer> local = new HashMap<>();
            int j = i;
            boolean isMatch = true;
            while(j < i + s2.length()) {
                if (!perms.containsKey(s2.charAt(j))) {
                    isMatch = false;
                    j++;
                    break;
                }
                local.merge(s2.charAt(j), 1, Integer::sum);
                if (local.get(s2.charAt(j)) > perms.get(s2.charAt(j))) {
                    isMatch = false;
                }
                j++;
            }
            if (isMatch) {
                return true;
            }
            i = j;
        }
        return false;
    }

    /**
     *
     * Really what we care about is the number of characters
     * IE is there a consecutive substring that contains the
     * exact characters of s1
     *
     * @param s1 the permutation string
     * @param s2 the string that may contain s1
     * @return if s2 contains s1
     */
    private static boolean arraysAsMap(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1map = new int[26]; // limited to lowercase
        for (Character c : s1.toCharArray()) {
            s1map[c - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) { //iterate over every start position
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) { // iterate over small string length
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * Really what we care about is the number of characters
     * IE is there a consecutive substring that contains the
     * exact characters of s1
     *
     * We can improve the arrays as map approach by only loading once,
     * and adjust as we move along - testing for the match.
     *
     * AKA a sliding window
     *
     * @param s1 the permutation string
     * @param s2 the string that may contain s1
     * @return if s2 contains s1
     */
    private static boolean slidingWindow(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1map = new int[26]; // limited to lowercase
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) { //iterate over every start position
            if (matches(s1map, s2map)) {
                return true;
            }
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }

    private static boolean matches(int[] s1, int[] s2) {
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }
}
