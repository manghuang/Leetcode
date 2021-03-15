package newyear.leetcode3.notebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution6 {

    //dfs
    //dfs+记忆化搜索
    //动态规划


////    private  int ans;
//    private int[] dp;
//    public int minCut(String s) {
//        if(s == null || s.length() == 0){
//            return 0;
//        }
////        ans = s.length();
//        dp = new int[s.length()];
//
//        Arrays.fill(dp, s.length());
//        dfs(s, 0);
//        return dp[0];
//    }
//
//    private int dfs(String s, int beginIndex) {
//        if(beginIndex >= s.length()){
//            return -1;
//        }
//        if(dp[beginIndex] != s.length()){
//            return dp[beginIndex];
//        }
//        for (int i = beginIndex; i < s.length(); i++) {
//            if(isOk(s, beginIndex, i)){
//                dp[beginIndex] = Math.min(dp[beginIndex] ,1+dfs(s, i+1));
//            }
//        }
//        return dp[beginIndex];
//    }
//
//    private boolean isOk(String s, int beginIndex, int endIndex) {
//        while (beginIndex <= endIndex){
//            if(s.charAt(beginIndex) != s.charAt(endIndex)){
//                return false;
//            }
//            beginIndex++;
//            endIndex--;
//        }
//        return true;
//    }

    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length+1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.min((dp[i-1]+1), get(s, i-1, dp));
        }
        return dp[dp.length -1] - 1;
    }

    private int get(String s, int endIndex, int[] dp) {
        int ans = endIndex+1;
        for (int i = 0; i < endIndex; i++) {
            if(isOk(s, i, endIndex)){
                ans = Math.min(ans, dp[i]+1);
            }
        }
        return ans;
    }

    private boolean isOk(String s, int beginIndex, int endIndex) {
        while (beginIndex <= endIndex){
            if(s.charAt(beginIndex) != s.charAt(endIndex)){
                return false;
            }
            beginIndex++;
            endIndex--;
        }
        return true;
    }
}
