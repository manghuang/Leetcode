package leetcode5;

public class Solution1 {

    /*
        方式一：KMP,其中一个是子串，和这个题意不符合
        方式二：暴力枚举   枚举子串的起点
        方式三：动态规划
                最长公共子序列
                最长公共子串
                令 dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀，那么答案即为所有 dp[i][j] 中的最大值。
                如果 A[i] == B[j]，那么 dp[i][j] = dp[i + 1][j + 1] + 1，否则 dp[i][j] = 0。
         方式四：滑动窗口   枚举数组的重合情况
     */
//    public int findLength(int[] A, int[] B) {
//        if(A == null || B == null || A.length == 0 || B.length == 0){
//            return 0;
//        }
//        int res = 0;
//        for(int i=0; i<A.length; i++){
//            for (int j = 0; j <B.length ; j++) {
//                int aIndex = i;
//                int bIndex = j;
//                int temp = 0;
//                while (aIndex<A.length && bIndex < B.length && A[aIndex] == B[bIndex]){
//                    temp++;
//                    aIndex++;
//                    bIndex++;
//                }
//                res = Math.max(res, temp);
//            }
//        }
//        return res;
//    }

//    public int findLength(int[] A, int[] B) {
//        if (A == null || B == null || A.length == 0 || B.length == 0) {
//            return 0;
//        }
//        int[][] dp = new int[A.length+1][B.length+1];
//        int res = 0;
//        for (int i = 1; i <dp.length ; i++) {
//            for (int j = 1; j <dp[0].length ; j++) {
//                if(A[i-1] == B[j-1]){
//                    dp[i][j] = dp[i-1][j-1]+1;
//                    res = Math.max(dp[i][j], res);
//                }else {
//                    dp[i][j] = 0;
//                }
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        int res = new Solution1().findLength(A, B);
        System.out.println(res);
    }

    public int findLength(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        int[] dp = new int[B.length + 1];//默认初始化为0
        int res = 0;
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = dp.length - 1; j >= 1; j--) {
                if (A[i - 1] == B[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                    res = Math.max(dp[j], res);
                } else {
                    dp[j] = 0;
                }
            }
        }
        return res;
    }
}
