package leetcode3;

public class Solution3 {
    public static void main(String[] args) {
        double res = new Solution3().new21Game(6, 2, 10);
//        System.out.println(res);
    }

    /*
        动态规划，倒推发，后面的状态不依赖于前面的状态，前面的状态依赖于后面的状态

        阶段为初始时候的累积和，设为i，取值范围为[0,K+W-1]
        状态为初始时候累积和为i时到结束的所有可能数目和在[K,N]范围内的数目

        设一个二维数组dp[i][2]:
             dp[i][0]:代表初始累积和为i开始，到结束的所有可能的数目
             dp[i][1]:代表初始累积和为i开始，到结束的所有可能中[K,N]范围内的数目

     */
    public double new21Game(int N, int K, int W) {
        int[][] dp = new int[K + W][2];
        for (int i = K; i <= K + W - 1; i++) {
            dp[i] = new int[2];
            if (i <= N) {
                dp[i][0] = 1;
                dp[i][1] = 1;
            } else {
                dp[i][0] = 1;
                dp[i][1] = 0;
            }
        }
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = new int[2];
            for (int j = 1; j <= W; j++) {
                dp[i][0] += dp[i + j][0];
                dp[i][1] += dp[i + j][1];
            }
        }
        for (int i = 0; i < K + W - 1; i++) {
            System.out.println("开始数字和：" + i + "  numSum:" + dp[i][0] + "  numOk:" + dp[i][1] + " 概率：" + (double) dp[i][1] / dp[i][0]);
        }
        return (double) dp[0][1] / dp[0][0];
    }
}
