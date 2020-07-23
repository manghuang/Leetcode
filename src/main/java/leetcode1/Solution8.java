package leetcode1;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution8 {
    public static void main(String[] args) {
        char[][] a = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int b = new Solution8().numIslands(a);
        System.out.println(b);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int result = 0;
        boolean[][] isVisit = new boolean[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            isVisit[i] = new boolean[grid[0].length];
            Arrays.fill(isVisit[i], false);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !isVisit[i][j]) {
                    isVisit[i][j] = true;
                    result++;
                    bfs(i, j, grid, isVisit);
                }
            }
        }
        return result;
    }

    private void bfs(int i, int j, char[][] grid, boolean[][] isVisit) {
        int[] X = {-1, 0, 1, 0};
        int[] Y = {0, 1, 0, -1};

        LinkedList<int[]> ll = new LinkedList<>();
        int[] node1 = {i, j};
        ll.offer(node1);
        while (!ll.isEmpty()) {
            int[] node2 = ll.remove();
            for (int k = 0; k < 4; k++) {
                int x = X[k] + node2[0];
                int y = Y[k] + node2[1];

                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1' && !isVisit[x][y]) {
                    int[] node3 = {x, y};
                    ll.offer(node3);
                    isVisit[x][y] = true;
                }
            }
        }
    }
}
