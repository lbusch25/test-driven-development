package com.lawson.testdrivendevelopment.search.breadthdepth;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryMatrixDistance {

    /**
     * update matrix to contain the distance
     * to the nearest 0.
     *
     * This is a simple BFS search with some dynamic programming
     * we can simplify the bfs calls when we hit a previously seen position.
     *
     * A prior position is on the same row or above and columns on the same row.
     *
     * Could do the dynamic programming to speed up bfs (since logical faster than q and object making)
     * can also just do  DP SOLUTION
     *
     * @param mat
     * @return
     */
    public static int[][] updateMatrix(int[][] mat) {
        return dpSolution(mat);
    }

    /**
     * A dp solution
     * What I didn't see initially is that two passes are needed
     *      1) Top Down
     *      2) Bottom up
     *
     * This is because dp can only check previously computed values.
     * And to compute the bottom right values we need to start from the bottom corner.
     *
     * @param mat
     * @return
     */
    private static int[][] dpSolution(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] solution = new int[rows][cols];

        //Check top and left solutions
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    solution[i][j] = 0;
                } else {
                    solution[i][j] = 100000; // default the array value without extra loop
                    if (i > 0) {
                        solution[i][j] = Math.min(solution[i][j], solution[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        solution[i][j] = Math.min(solution[i][j], solution[i][j - 1] + 1);
                    }
                }
            }
        }

        // Check right and bottom solutions
        for(int i = rows - 1; i >= 0; i--) {
            for(int j = cols - 1; j >= 0 ; j--) {
                if (mat[i][j] == 0) {
                    solution[i][j] = 0;
                } else {
                    if (i < rows - 1) {
                        solution[i][j] = Math.min(solution[i][j], solution[i + 1][j] + 1);
                    }
                    if (j < cols - 1) {
                        solution[i][j] = Math.min(solution[i][j], solution[i][j + 1] + 1);
                    }
                }
            }
        }
        return solution;
    }

    /**
     * an implementation using breadth first search
     * @param mat
     * @return
     */
    private static int[][] bfsSolution(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = bfs(i, j, n, m, mat);
            }
        }
        return mat;
    }

    private static int bfs(int sr, int sc, int n, int m, int[][] mat) {
        int[][] seen = new int[n][m];
        int distance = 0;
        Deque<BFSNode> q = new LinkedList<>();
        q.add(new BFSNode(sr, sc));
        while(!q.isEmpty()) {
            BFSNode node = q.poll();
            if (seen[node.r][node.c] != 1) {
                if (mat[node.r][node.c] == 0) {
                    return Math.abs(node.r - sr) + Math.abs(node.c - sc);
                }
                seen[node.r][node.c] = 1;
                distance++;
                if (node.r > 0) {
                    q.add(new BFSNode(node.r - 1, node.c));
                }
                if (node.c > 0) {
                    q.add(new BFSNode(node.r, node.c - 1));
                }
                if (node.r < n - 1) {
                    q.add(new BFSNode(node.r + 1, node.c));
                }
                if (node.c < m - 1) {
                    q.add(new BFSNode(node.r, node.c + 1));
                }
            }
        }
        return distance;
    }

    private static class BFSNode {

        public BFSNode(Integer r, Integer c) {
            this.r = r;
            this.c = c;
        }

        protected Integer r;
        protected Integer c;
    }
}
