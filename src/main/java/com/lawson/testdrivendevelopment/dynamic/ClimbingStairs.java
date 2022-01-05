package com.lawson.testdrivendevelopment.dynamic;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        // distinct steps should be the sum of the prior two steps
        int[] seen = new int[n];
        seen[0] = 1;
        seen[1] = 2;
        for (int i = 2; i < n; i++) {
            seen[i] = seen[i -1] + seen[i - 2];
        }
        return seen[n - 1];
    }
}
