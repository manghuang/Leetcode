package leetcode5;

public class Solution7 {

    public static void main(String[] args) {
        int[][] nums = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int res = new Solution7().uniquePathsWithObstacles(nums);
        System.out.println(res);
    }

    /*
        方式一、dps,因为存在重复计算，超时，优化的话，使用回溯，在记录每个状态，进而发展为了动态规划
        方式二、bps,求多少条路径，而不是是否有一条满足条件的路径，和dps一样存在重复计算，会超时
        方式三、动态规划， dp[i][j]表示位置x=i,y=j处的点到右下角点的路径数
               if o[i][j]==0 : dp[i][j] = dp[i-1][j] + dp[i][j-1]
               if o[i][j]==1 : dp[i][j] = 0
     */
//    private int ans;
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null
//        || obstacleGrid[0].length == 0){
//            return 0;
//        }
//        if(obstacleGrid[0][0] == 1){
//            return 0;
//        }
//        dps(obstacleGrid, 0, 0);
//        return this.ans;
//    }
//
//    private void dps(int[][] obstacleGrid, int x, int y) {
//        int xLength = obstacleGrid.length;
//        int yLength = obstacleGrid[0].length;
//        if(x == xLength-1 && y == yLength - 1){
//            if(obstacleGrid[x][y] == 0){
//                this.ans++;
//            }
//        }
//        if(x+1 < xLength){
//            if(obstacleGrid[x+1][y] == 0){
//                dps(obstacleGrid, x+1, y);
//            }
//        }
//        if(y+1 < yLength){
//            if(obstacleGrid[x][y+1] == 0){
//                dps(obstacleGrid, x, y+1);
//            }
//        }
//    }
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null
//        || obstacleGrid[0].length == 0){
//            return 0;
//        }
//        int xLength = obstacleGrid.length;
//        int yLength = obstacleGrid[0].length;
//        if(obstacleGrid[0][0] == 1 || obstacleGrid[xLength-1][yLength-1] == 1){
//            return 0;
//        }
//        int[][] dp = new int[xLength][yLength];
//        dp[xLength-1][yLength-1] = 1;
//        for (int i = xLength-1; i >=0 ; i--) {
//            for (int j = yLength-1; j >=0 ; j--) {
//                if(obstacleGrid[i][j] == 0){
//                    if(i < xLength-1){
//                        dp[i][j] += dp[i+1][j];
//                    }
//                    if(j <yLength-1){
//                        dp[i][j] += dp[i][j+1];
//                    }
//                }else {
//                    dp[i][j] = 0;
//                }
//            }
//        }
//        return dp[0][0];
//    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null
                || obstacleGrid[0].length == 0) {
            return 0;
        }
        int xLength = obstacleGrid.length;
        int yLength = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[xLength - 1][yLength - 1] == 1) {
            return 0;
        }
        int[] dp = new int[yLength];
        dp[yLength - 1] = 1;
        for (int i = xLength - 1; i >= 0; i--) {
            for (int j = yLength - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    if (j < yLength - 1) {
                        dp[j] += dp[j + 1];
                    }
                }
            }
        }
        return dp[0];
    }
}
