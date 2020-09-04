package leetcode7;

public class Solution8 {

    //    public boolean PredictTheWinner(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return true;
//        }
//        int[] res = dps(nums, 0, nums.length-1, true);
//        if(res[0] >= res[1]){
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//    private int[] dps(int[] nums, int left, int right, boolean isOneTurn) {
//        int[] res = new int[2];
//        if(left > right){
//            return res;
//        }
//        int[] a = dps(nums, left+1, right, !isOneTurn);
//        int[] b = dps(nums, left, right-1, !isOneTurn);
//        if(isOneTurn){
//            if(a[0]+nums[left] >= b[0]+nums[right]){
//                res[0] = nums[left] + a[0];
//                res[1] = a[1];
//            }else {
//                res[0] = nums[right] + b[0];
//                res[1] = b[1];
//            }
//
//        }else {
//            if(a[1]+nums[left] >= b[1]+nums[right]){
//                res[0] = a[0];
//                res[1] = nums[left] + a[1];
//            }else {
//                res[0] = b[0];
//                res[1] = nums[right] + b[1];
//            }
//        }
//        return res;
//    }
//
//
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 2};
        boolean res = new Solution8().PredictTheWinner(a);
        System.out.println(res);
    }

    /*
        方法一：模拟， dps+回溯
        方法二：动态规划   dp[i][j] length = 3;
                        0   1   2
                      0 a   d
                      1     b   d
                      2         c
     */
    public boolean PredictTheWinner(int[] nums) {

        if (nums == null || nums.length == 0) {
            return true;
        }
        int length = nums.length;
        int isOneTure = nums.length % 2;
        int[][] dp = new int[length][length];
        for (int r = 0; r < length; r++) {
            for (int i = 0; i < length - r; i++) {
                int j = i + r;
                if ((r + 1) % 2 == isOneTure) {
                    if (r == 0) {
                        dp[i][j] = nums[i];
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j] + nums[i], dp[i][j - 1] + nums[j]);
                    }
                } else {
                    if (r == 0) {
                        dp[i][j] = -nums[i];
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j] - nums[i], dp[i][j - 1] - nums[j]);
                    }
                }
            }
        }
        return dp[0][length - 1] >= 0;
    }

}
