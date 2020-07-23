package leetcode6;

import java.util.List;

public class Solution4 {
    /*
        分析：可以拆解为一个个子问题，满足无后向性，并且子问题的解可以多次利用
        方式一：dps
        方式二：dps+回溯
        方式三：在方式二的基础上使用一个容器记录中间状态，减少重复计算，进行时间优化
        方式四：动态规划
        方式五：在方式四的基础上优化空间
     */
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if(triangle == null || triangle.size() == 0 || triangle.get(0) == null
//            || triangle.get(0).size() == 0){
//            return 0;
//        }
//        int xLength = triangle.size();
//        int[][] dp= new int[xLength][xLength];
//        for (int i = 0; i < xLength ; i++) {
//            for (int j = 0; j <= i ; j++) {
//                List<Integer> list = triangle.get(i);
//                dp[i][j] = list.get(j);
//            }
//        }
//        for (int i = xLength-2; i >=0 ; i--) {
//            for (int j = 0; j <= i ; j++) {
//                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) +dp[i][j];
//            }
//        }
//        return dp[0][0];
//    }
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0) == null
                || triangle.get(0).size() == 0) {
            return 0;
        }
        int xLength = triangle.size();
        int[] dp = new int[xLength];
        for (int i = xLength - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                if (i == xLength - 1) {
                    dp[j] = list.get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
                }
            }
        }
        return dp[0];
    }
}
