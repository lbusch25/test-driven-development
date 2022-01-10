package com.lawson.testdrivendevelopment.dynamic;

import java.util.HashMap;

public class Fibonacci {

    // d(n) = d(n -1) + d(n - 2) + d(n - 3)
    public static int tribonacci(int n) {
        return tribBottomUp(n);
    }

    private static int tribBottomUp(int n) {
        if (n == 0) {
            return n;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        int[] trib = new int[n + 1];
        trib[1] = 1;
        trib[2] = 1;
        for(int i = 3; i < n + 1; i++) {
            trib[i] = trib[i - 1] + trib[i - 2] + trib[i - 3];
        }
        return trib[n];
    }

    private static int tribTopDown(int n) {
        HashMap<Integer, Integer> solved = new HashMap<>();
        solved.put(0, 0);
        solved.put(1, 1);
        solved.put(2, 1);
        return tribDp(n - 1, solved) + tribDp(n -2, solved) + tribDp(n - 3, solved);
    }

    private static int tribDp(int n, HashMap<Integer, Integer> solved) {
        if (solved.containsKey(n)) {
            return solved.get(n);
        } else {
            int t = tribDp(n - 1, solved) + tribDp(n - 2, solved) + tribDp(n - 3, solved);
            solved.put(n, t);
            return t;
        }
    }
}
