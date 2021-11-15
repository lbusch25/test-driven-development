package com.lawson.testdrivendevelopment.strings;

public class Reverse {

    /**
     * Must be done in O(n) time with O(1) memory
     * @param s string to reverse
     */
    public static void reverseString(char[] s) {
        char temp;
        int right = s.length - 1;
        int left = 0;
        while(left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
            left++;
        }
    }

    /**
     *
     * @param s string to reverse
     * @return a string whose words are reversed but in the same order
     *
     * I'm not going to do this the hard way but here's how
     * Manually - two pointers - one at words start and one at words end
     * pass word to reverse function above then add to new string with space
     */
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for(String word : words) {
            StringBuilder temp = new StringBuilder();
            temp.append(word).reverse().append(" ");
            builder.append(temp);
        }
        builder.replace(builder.length() - 1, builder.length(), "");
        return builder.toString();
    }
}
