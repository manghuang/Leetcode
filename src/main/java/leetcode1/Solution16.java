package leetcode1;

public class Solution16 {
    public int maximalSquare(char[][] matrix) {
        int result = 0;

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        int[][] dp = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            dp[i] = new int[matrix[0].length];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    }
                    result = Math.max(result, dp[i][j]);
                }

            }
        }
        result = result * result;
        return result;
    }
}
