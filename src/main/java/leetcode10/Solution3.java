package leetcode10;

import java.util.Arrays;
import java.util.HashMap;

public class Solution3 {

    /*
        思想一：对于每一个数有拿和不拿两种情况
        思想二：下一个数一定要拿，拿哪个是个问题
     */
//    private short[][] dp;
//    public boolean canPartition(int[] nums) {
//        if(nums.length == 1){
//            return false;
//        }
//        int sum = 0;
//        for (int num: nums
//             ) {
//            sum += num;
//        }
//        if(sum % 2 == 1){
//            return false;
//        }else {
//            sum = sum / 2;
//        }
//        // 从里面取数字和为sum
//        dp = new short[nums.length][sum+1];
//        for (short[] temp: dp
//             ) {
//            Arrays.fill(temp, (short) -1);
//        }
//        Arrays.sort(nums);
//        return  dps(nums, 0, sum - nums[nums.length-1]);
//    }
//
//    private boolean dps(int[] nums, int index, int target) {
//        if(target == 0){
//            return true;
//        }else if(target < 0){
//            return false;
//        }
//        if(index >= nums.length-1){
//            return false;
//        }
//        boolean no = false;
//        if(dp[index][target] != -1){
//            no = dp[index][target] == 1;
//        }else {
//            no =  dps(nums, index+1, target);
//            dp[index][target] = (short) (no ? 1 : 0);
//        }
//        boolean yes = false;
//        int num = target - nums[index];
//        if(num >= 0){
//            if(dp[index][num] != -1){
//                yes = dp[index][num] == 1;
//            }else {
//                yes = dps(nums, index+1, num);
//                dp[index][num] = (short) (yes ? 1: 0);
//            }
//        }
//        return no || yes;
//    }
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length < 2) return false;
        int sum = 0;
            for (int num : nums){
            sum += num;
        }
            if (sum % 2 != 0) return false;
        int target = sum/2;
            return dfs(nums, target, 0);
    }
    public boolean dfs(int[] nums, int target, int index){
        if (target == 0) return true;
        if (target < 0) return false;
        for (int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i - 1]) continue;
            if (dfs(nums, target - nums[i], i + 1)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,3,3};
        boolean res = new Solution3().canPartition(nums);
        System.out.println(res);

    }
}
