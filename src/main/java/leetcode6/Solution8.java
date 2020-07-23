package leetcode6;

public class Solution8 {

    /*
        开区间
            0   1   2   3
         0  0   0
         1      0   0
         2          0   0
         3              0
     */
    public int maxCoins(int[] nums) {
        int length = nums.length;
        int[] val = new int[length + 2];
        val[0] = 1;
        val[length + 1] = 1;
        System.arraycopy(nums, 0, val, 1, length);
        int[][] dp = new int[length + 2][length + 2];
        for (int r = 2; r <= length + 1; r++) {
            for (int i = 0; i <= length + 1 - r; i++) {
                int j = i + r;
                for (int k = i + 1; k <= j - 1; k++) {
                    int a = val[i] * val[k] * val[j];
                    int s = dp[i][k] + a + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], s);
                }
            }
        }
        return dp[0][length + 1];
    }

}

