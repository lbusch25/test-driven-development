package com.lawson.testdrivendevelopment.dynamic;

public class MaximalSquare {

    /*
     * Returns the largest square of 1s in the matrix
     * dp[row][col] = largest possible square whose bottom right corner
     *          is matrix[row][col]
     *
     * base case is 0 = 0
     *
     * We have two cases per location - 1 or 0
     *      if 0 do nothing
     *      if 1
     *          check aboce, behind, diagnol in seen
     *              increment from minimum neighbor (if square theyll all be equal)
     *          update maxSquare
     */
    public static int maximalSquare(char[][] matrix) {
        var maxSquare = 0;
        var seen = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < matrix.length + 1; i++) {
            for (int j = 1; j < matrix[0].length + 1; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // increment from the minimum of the three prior spots
                    seen[i][j] = Math.min(Math.min(seen[i - 1][j - 1], seen[i-1][j]), seen[i][j-1]) + 1;
                    maxSquare = Math.max(maxSquare, seen[i][j]);
                }
            }
        }
        return maxSquare*maxSquare;
    }
}
