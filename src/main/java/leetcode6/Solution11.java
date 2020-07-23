package leetcode6;

public class Solution11 {
    /*
        方式一：dps
        方式二：dps+剪枝(对方式一的优化)
        方式三：dps+回溯
        方式四：dps+回溯+记忆化搜索(对方式三的优化)
        方式五：动态规划
        方式六：动态规划+滚动数组(对方式五的优化)
     */
//    private int res = Integer.MAX_VALUE;
//    public int minPathSum(int[][] grid) {
//        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
//            return -1;
//        }
//        dps(grid, 0, 0, 0);
//        return this.res;
//    }
//
//    private void dps(int[][] grid, int x, int y, int distance) {
//        int xLength = grid.length;
//        int yLength = grid[0].length;
//        if(x >= xLength || y >= yLength){
//            return;
//        }
//        int value = distance + grid[x][y];
//        if(value >= this.res){
//            return;
//        }
//        if(x == xLength-1 && y == yLength-1){
//            this.res = Math.min(this.res, value);
//        }
//        dps(grid, x+1, y, value);
//        dps(grid, x, y+1, value);
//    }

//    private int[][] dp;
//    public int minPathSum(int[][] grid) {
//        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
//            return -1;
//        }
//        this.dp = new int[grid.length][grid[0].length];
//        for (int[] a: dp
//             ) {
//            Arrays.fill(a, -1);
//        }
//        return dps(grid, 0, 0);
//    }
//
//    private int dps(int[][] grid, int x, int y) {
//        int xLength = grid.length;
//        int yLength = grid[0].length;
//
//        if(x == xLength-1  && y == yLength-1){
//            return grid[x][y];
//        }
//        if (dp[x][y] == -1){
//            int value1 = Integer.MAX_VALUE;
//            int value2 = Integer.MAX_VALUE;
//            if(x < xLength-1){
//                value1 = grid[x][y] + dps(grid, x+1, y);
//            }
//            if(y < yLength -1){
//                value2 = grid[x][y] + dps(grid, x, y+1);
//            }
//            dp[x][y] = Math.min(value1, value2);
//        }
//        return dp[x][y];
//    }

//    public int minPathSum(int[][] grid) {
//        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0){
//            return -1;
//        }
//        int xLength = grid.length;
//        int yLength = grid[0].length;
//        int[][] dp = new int[xLength][yLength];
//        for (int i=xLength-1; i>=0; i--){
//            for (int j = yLength-1; j >=0 ; j--) {
//                if (i == xLength-1){
//                    if(j == yLength-1){
//                        dp[i][j] = grid[i][j];
//                    }else {
//                        dp[i][j] = grid[i][j] + dp[i][j+1];
//                    }
//                    continue;
//                }
//                if(j == yLength-1){
//                    dp[i][j] = grid[i][j] + dp[i+1][j];
//                }else {
//                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
//                }
//            }
//        }
//        return dp[0][0];
//    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int xLength = grid.length;
        int yLength = grid[0].length;
        int[] dp = new int[yLength];
        for (int i = xLength - 1; i >= 0; i--) {
            for (int j = yLength - 1; j >= 0; j--) {
                if (i == xLength - 1) {
                    if (j == yLength - 1) {
                        dp[j] = grid[i][j];
                    } else {
                        dp[j] = grid[i][j] + dp[j + 1];
                    }
                    continue;
                }
                if (j == yLength - 1) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}
