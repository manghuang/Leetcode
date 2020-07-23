package leetcode6;

public class Solution7 {


    /*
       方式一、 dps+回溯
       方式二、 动态规划
     */
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if(s1 == null || s2 == null || s3 == null){
//            return false;
//        }
//        if(s1.length() + s2.length() != s3.length()){
//            return false;
//        }
//        return  dps(s1, 0, s2, 0, s3, 0);
//    }
//
//    private boolean dps(String s1, int index1, String s2, int index2, String s3, int index3) {
//        if(index3 >= s3.length()){
//            return true;
//        }
//        boolean isok = false;
//        if(index1 < s1.length()){
//            if(s1.charAt(index1) == s3.charAt(index3)){
//                isok = dps(s1, index1+1, s2, index2, s3, index3+1);
//            }
//        }
//        if(isok){
//            return true;
//        }
//        if(index2 < s2.length()){
//            if(s2.charAt(index2) == s3.charAt(index3)){
//                isok =  dps(s1, index1, s2, index2+1, s3, index3+1);
//            }
//        }
//        return isok;
//    }

    public static void main(String[] args) {
        boolean res = new Solution7().isInterleave("db", "b", "cbb");
        System.out.println(res);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        // 状态和转移方程是什么？
        int length1 = s1.length();
        int length2 = s2.length();
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= length1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= length2; i++) {
            dp[0][i] = dp[i][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                int index3 = i + j - 1;
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(index3))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(index3));
            }
        }
        return dp[length1][length2];
    }
}
