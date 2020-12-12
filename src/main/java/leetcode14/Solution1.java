package leetcode14;

public class Solution1 {

    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0){
            return  0;
        }
        int length = nums.length;
        // 下标0:正0负   下标1:以此结尾的最长摆动序列长度
        int[][] dp = new int[length][2];
        for (int i = 0; i <length ; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for(int i=1; i<length; i++){
            for(int j=i-1; j>= 0; j--){
                if(nums[j] != nums[i]){
                    if(dp[j][0] == 0){
                        if(dp[i][1] < 2){
                            dp[i][0] = nums[i] > nums[j] ? 1 : -1;
                            dp[i][1] = 2;
                        }
                    }else {
                        int temp = nums[i] > nums[j] ? 1 : -1;
                        if(temp + dp[j][0] == 0){
                            if(dp[i][1] < dp[j][1] + 1){
                                dp[i][0] = temp;
                                dp[i][1] = dp[j][1] + 1;
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i <length ; i++) {
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}
