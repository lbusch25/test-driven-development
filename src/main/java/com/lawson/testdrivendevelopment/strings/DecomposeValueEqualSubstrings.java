package com.lawson.testdrivendevelopment.strings;

public final class DecomposeValueEqualSubstrings {

    private DecomposeValueEqualSubstrings() {
        //hidden constructor for class
    }

    public static boolean isDecomposable(String s) {
        if (s.isEmpty()) {
            return false;
        }
        var substringLengthTwo = false;
        char lastSeen = s.charAt(0);
        var count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != lastSeen) {
                lastSeen = s.charAt(i);
                if (count == 2) {
                    if (substringLengthTwo) {
                        return false;
                    }
                    substringLengthTwo = true;
                } else if (count != 3) {
                    return false;
                }
                count = 0;
            }
            count++;
        }
        if (count == 2) {
            return !substringLengthTwo;
        } else if (count != 3) {
            return false;
        }
        return substringLengthTwo;
    }

}
