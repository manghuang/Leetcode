package leetcode7;

public class Solution0 {

    public static void main(String[] args) {
        int res = new Solution0().integerBreak(10);
        System.out.println(res);
    }

    /*
        动态规划：从小到大
     */
    public int integerBreak(int n) {
        if (n < 2) {
            return -1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int res = 1;
            for (int j = 1; j <= i / 2; j++) {
                int temp = Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]);
                res = Math.max(res, temp);
            }
            dp[i] = res;
        }
        return dp[n];
    }

}
