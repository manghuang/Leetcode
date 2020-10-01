package leetcode9;

public class Solution10 {

//    public int minimumOperations(String leaves) {
//        if(leaves.length() < 3){
//            return -1;
//        }
//        int res = 0;
//        if(leaves.charAt(0) != 'r'){
//            res++;
//        }
//        if(leaves.charAt(leaves.length()-1) != 'r'){
//            res++;
//        }
//        int start = 1;
//        int end = leaves.length()-2;
//        while (leaves.charAt(start) == 'r' && start <= end){
//            start++;
//        }
//        while (leaves.charAt(end) == 'r' && start <= end){
//            end--;
//        }
//        if(start > end){
//            return res+1;
//        }else if(start == end){
//            return res;
//        }else {
//
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int res = new Solution10().minimumOperations("yry");
        System.out.println(res);
    }

    // 动态规划：dp[i][j]表示第0-i范围内的叶子调整到第i个叶子处于j状态需要的值
    // 总共有三个状态，用0、1、2表示
    public int minimumOperations(String leaves) {
        int length = leaves.length();
        int[][] dp = new int[length][3];

        dp[0][0] = leaves.charAt(0) == 'r' ? 0 : 1;
        dp[1][0] = dp[0][0] + (leaves.charAt(1) == 'r' ? 0 : 1);
        dp[1][1] = dp[0][0] + (leaves.charAt(1) == 'y' ? 0 : 1);
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
        for (int i = 2; i < length; i++) {
            int toRed = leaves.charAt(i) == 'r' ? 0 : 1;
            int toYellow = 1 - toRed;
            dp[i][0] = dp[i - 1][0] + toRed;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + toYellow;
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + toRed;
        }
        return dp[length - 1][2];
    }
}
