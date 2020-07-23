package leetcode6;

public class Solution0 {

    /*
        方式一：dps+回溯
                    两种状态：待买，待卖
                        待买时候，可以选择买或者不买
                        待卖时候可以选择卖或者不卖
                        层数代表天数
                        对所有可能情况的枚举
               优化：使用一个数组记录状态
         方式二：动态规划
                    状态是什么？
                    dp[2][length]
     */
//    private int[][] dp;
//    public int maxProfit(int[] prices) {
//        if(prices == null || prices.length == 0){
//            return 0;
//        }
//        this.dp = new int[2][prices.length+2];
//        Arrays.fill(dp[0], Integer.MAX_VALUE);
//        Arrays.fill(dp[1], Integer.MAX_VALUE);
//        return dps(prices, false, 0);
//    }
//
//    private int dps(int[] prices, boolean isHaving, int dayIndex) {
//        if(dayIndex >= prices.length){
//            return 0;
//        }
//        int a,b;
//        if(isHaving){
//            if(dp[1][dayIndex+1] == Integer.MAX_VALUE){
//                a = dps(prices, true, dayIndex+1);
//                dp[1][dayIndex+1] = a;
//            }else {
//                a = dp[1][dayIndex+1];
//            }
//            if(dp[0][dayIndex+2] == Integer.MAX_VALUE){
//                b = dps(prices, false, dayIndex+2);
//                dp[0][dayIndex+2] = b;
//            }else {
//                b = dp[0][dayIndex+2];
//            }
//            b = b + prices[dayIndex];
//        }else {
//            if(dp[0][dayIndex+1] == Integer.MAX_VALUE){
//                a = dps(prices, false, dayIndex+1);
//                dp[0][dayIndex+1] = a;
//            }else {
//                a = dp[0][dayIndex+1];
//            }
//            if(dp[1][dayIndex+1] == Integer.MAX_VALUE){
//                b = dps(prices, true, dayIndex+1);
//                dp[1][dayIndex+1] = b;
//            }else {
//                b = dp[1][dayIndex+1];
//            }
//            b = b - prices[dayIndex];
//        }
//        return Math.max(a,b);
//    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        /*
            0:需要买入
            1：需要卖出
         */
        int[][] dp = new int[length][2];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {

                } else {

                }
            }
        }
        return Math.max(dp[0][length - 1], dp[1][length - 1]);
    }

}
