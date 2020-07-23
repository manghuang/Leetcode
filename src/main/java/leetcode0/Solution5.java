package leetcode0;

import java.util.ArrayList;

class Solution5 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        System.out.println(new Solution5().maxDistance(grid));
    }

    public int maxDistance(int[][] grid) {
        //找出所有陆地，找出所有海洋
        //计算某个海洋到陆地之间的距离，取最小值
        //计算所有海洋到陆地的距离值，取最大值
        int N = grid.length;
        ArrayList<Location> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    al.add(new Location(i, j));
                }
            }
        }
        if (al.size() == 0 || al.size() == N * N) return -1;
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    int min = 2 * N;
                    for (Location loc : al) {
                        min = Math.min(min, Math.abs(loc.getX() - i) + Math.abs(loc.getY() - j));
                    }
                    max = Math.max(max, min);
                }
            }
        }
        return max;

    }

    class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
