package com.lawson.testdrivendevelopment.dynamic;

public class LongestCommonSubsequence {

    /*
     * dp[i][j] represents the longest subsequence of text1[0...i]text2[0...j]
     *
     * dp[i][j] = DP[i-1][j-1] + 1 if text1[i] == text2[j]
     * dp[i][j] = max(DP[i-1][j], DP[i][j - 1]) otherwise
     *
     * base case = 0
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        return bottomUpSolution(text1, text2);
    }

    private static int bottomUpSolution(String text1, String text2) {
        //var length = Math.min(text1.length(), text2.length()); // this only works if array is square
        var seen = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                char ti1 = text1.charAt(i - 1);
                char tj2 = text2.charAt(j - 1);
                if (ti1 == tj2) {
                    seen[i][j] = seen[i - 1][j-1] + 1;
                } else {
                    seen[i][j] = Math.max(seen[i-1][j], seen[i][j-1]);
                }
            }
        }
        return seen[text1.length()][text2.length()];
    }

    private static int topDownSolution(String text1, String text2) {
        var memo = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                memo[i][j] = -1; // indicates if we have touched this spot
            }
        }
        return topDownDP(0, 0, memo, text1, text2);
    }

    private static int topDownDP(int i, int j, int[][] memo, String text1, String text2) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + topDownDP(i + 1, j + 1, memo, text1, text2);
        } else {
            memo[i][j] = Math.max(topDownDP(i, j + 1, memo, text1, text2),
                    topDownDP(i + 1, j, memo, text1, text2));
        }
        return memo[i][j];
    }
}
