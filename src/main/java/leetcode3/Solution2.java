package leetcode3;

import java.util.Arrays;

/**
 * 方式一：暴力枚举所有情况
 * 方式二：动态规划
 * 正推：
 * 状态：选择一个数字后的累加和sum
 * 状态转移方程：如果小于k，则继续抽牌，反之，则停止抽牌
 * 边界，刚开始时候sum=0
 * 倒推：
 * dp[x] 表示从得分为 x 的情况开始游戏并且获胜的概率，目标是求 dp[0] 的值。
 */
public class Solution2 {
    private int numSum;
    private int numOk;

    public static void main(String[] args) {
        double res = new Solution2().new21Game(6, 2, 10);
    }

    public double new21Game2(int N, int K, int W) {
        for (int i = 0; i < K; i++) {
            this.numSum = 0;
            this.numOk = 0;
            dps(N, K, W, i);
            System.out.println("开始数字和：" + i + "  numSum:" + numSum + "  numOk:" + numOk + " 概率：" + (double) numOk / numSum);
        }

        return (double) numOk / numSum;
    }

    private void dps(int n, int k, int w, int sum) {
        if (sum >= k) {
            this.numSum++;
            if (sum <= n) {
                this.numOk++;
            }
            return;
        }
        for (int i = 1; i <= w; i++) {
            dps(n, k, w, sum + i);
        }
    }

    public double new21Game(int N, int K, int W) {
        double[] dp = new double[K + W + 1];
        for (int i = K; i < dp.length; i++) {
            if (i <= N) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }
        double sum = 0;
        for (int i = K + 1; i <= K + W; i++) {
            sum += dp[i];
        }
        for (int i = K - 1; i >= 0; i--) {
            sum = sum - dp[i + W + 1] + dp[i + 1];
            dp[i] = sum / W;
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println("位置：" + i + "胜率：" + dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
