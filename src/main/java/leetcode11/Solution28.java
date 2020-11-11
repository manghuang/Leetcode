package leetcode11;

import java.util.Arrays;

public class Solution28 {

    public int countSquares(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return 0;
        }
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        int res = 0;
//        int[][] dp = new int[xLength][yLength];
        int[] dp = new int[yLength];
        int temp = 0;
        for (int[] ints : matrix) {
//            System.out.println(Arrays.toString(dp));
            for (int j = 0; j < yLength; j++) {
                if (j == 0) {
                    temp = dp[j];
                    if (ints[j] == 1) {
                        dp[j] = 1;
                        res++;
                    }else {
                        dp[j] = 0;
                    }
                } else {
                    if (ints[j] == 1) {
                        int a  = Math.min(temp, Math.min(dp[j - 1], dp[j])) + 1;
                        temp = dp[j];
                        dp[j] = a;
                        res += dp[j];
                    }else {
                        temp = dp[j];
                        dp[j] = 0;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return res;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
                };
        int res = new Solution28().countSquares(a);
        System.out.println(res);
    }
}
