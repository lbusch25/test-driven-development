package com.lawson.testdrivendevelopment.search.breadthdepth;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxIslandArea {

    private static int[][] gridCopy;
    private static int[][] seenCopy;

    /**
     * An island is marked with a value of 1,
     * water is 0. Need to find the largest island
     * within the grid.
     *
     * Two searches really
     *  1) Find islands
     *  2) Calculate their size
     *
     *  Initial approach will have a lot of repeat work,
     *  essentially scan array for an island then bfs or dfs
     *  the actual island for its area.
     *
     *  Downside is it will repeat scan islands for every position - pretty
     *  big downside (IE if entire island it will do this for every position).
     *
     *  => we need a grid to keep track of prior islands
     *
     *  How to improve - kick of simple dfs / bfs at every node,
     *  but stop if we have seen said node before
     *
     *  Can also just mark original array with 0s to avoid seen array
     *
     * @param grid the array to search for islands
     * @return the max area island
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        gridCopy = grid;
        seenCopy = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && seenCopy[i][j] != 1) {
                    // search implementation here
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int r, int c) {
        int area = 0;
        if (gridCopy[r][c] == 1 && seenCopy[r][c] != 1) {
            seenCopy[r][c] = 1;
            area += 1;
            if (r > 0) {
                area += dfs(r - 1, c);
            }
            if (c > 0) {
                area += dfs(r, c - 1);
            }
            if (r < gridCopy.length - 1) {
                area += dfs(r + 1, c);
            }
            if (c < gridCopy[0].length - 1) {
                area += dfs(r, c + 1);
            }
        }
        return area;
    }

    private static int bfs(int r, int c) {
        int area = 0;
        Deque<BFSNode> q = new ArrayDeque<>();
        q.add(new BFSNode(r, c));
        while(!q.isEmpty()) {
            BFSNode n = q.poll();
            if (gridCopy[n.r][n.c] == 1 && seenCopy[n.r][n.c] != 1) {
                area += 1;
                seenCopy[n.r][n.c] = 1;
                if (n.r > 0) {
                    q.add(new BFSNode(n.r - 1, n.c));
                }
                if (n.c > 0) {
                    q.add(new BFSNode(n.r, n.c - 1));
                }
                if (n.r < gridCopy.length - 1) {
                    q.add(new BFSNode(n.r + 1, n.c));
                }
                if (n.c < gridCopy[0].length - 1) {
                    q.add(new BFSNode(n.r, n.c + 1));
                }
            }
        }
        return area;
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
