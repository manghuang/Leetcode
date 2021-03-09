package newyear.leetcode2;

import java.util.Arrays;

public class Solution3 {

    private static final int mod = (int) (Math.pow(10, 9) + 7);

    private int[][] dp;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        dp = new int[group.length + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(n, minProfit, group, profit, 0, 0) % mod;

    }

    private int dfs(int n, int minProfit, int[] group, int[] profit, int index, int sum) {
        if (index >= group.length) {
            if (sum >= minProfit) {
                return 1;
            }
            return 0;
        }
        if(dp[index][n] != -1){
            return dp[index][n];
        }
        long choose = 0;
        if((n - group[index]) >= 0){
            choose = dfs(n - group[index], minProfit, group, profit, index + 1, Math.min(minProfit, sum + profit[index]));
        }
        long notChoose = dfs(n, minProfit, group, profit, index + 1, sum);

        dp[index][n] = Math.toIntExact((choose % mod + notChoose % mod) % mod);
        return dp[index][n];
    }

    public static void main(String[] args) {
        int ans = new Solution3().profitableSchemes(
                95,
                53,
                new int[]{82, 7, 18, 34, 1, 3, 83, 56, 50, 34, 39, 38, 76, 92, 71, 2, 6, 74, 1, 82, 22, 73, 88, 98, 6, 71, 6, 26, 100, 75, 57, 88, 43, 16, 22, 89, 7, 9, 78, 97, 22, 87, 34, 81, 74, 56, 49, 94, 87, 71, 59, 6, 20, 66, 64, 37, 2, 42, 30, 87, 73, 16, 39, 87, 28, 9, 95, 78, 43, 59, 87, 78, 2, 93, 7, 22, 21, 59, 68, 67, 65, 63, 78, 20, 82, 35, 86},
                new int[]{45, 57, 38, 64, 52, 92, 31, 57, 31, 52, 3, 12, 93, 8, 11, 60, 55, 92, 42, 27, 40, 10, 77, 53, 8, 34, 87, 39, 8, 35, 28, 70, 32, 97, 88, 54, 82, 54, 54, 10, 78, 23, 82, 52, 10, 49, 8, 36, 9, 52, 81, 26, 5, 2, 30, 39, 89, 62, 39, 100, 67, 33, 86, 22, 49, 15, 94, 59, 47, 41, 45, 17, 99, 87, 77, 48, 22, 77, 82, 85, 97, 66, 3, 38, 49, 60, 66}
        );
        System.out.println(ans);
    }
}
