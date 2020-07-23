package leetcode2;

public class Solution1 {
    //暴力
//    public int maxProduct(int[] nums) {
//        if(nums == null){
//            return Integer.MIN_VALUE;
//        }
//        int result = Integer.MIN_VALUE;
//        for(int i=0; i<nums.length; i++){
//            int temp = 1;
//            for(int j=i; j<nums.length; j++){
//                temp *=nums[j];
//                if(temp > result){
//                    result = temp;
//                }
//            }
//        }
//
//        return result;
//    }
    //动态规划
    public int maxProduct(int[] nums) {
        if (nums == null) {
            return Integer.MIN_VALUE;
        }
        int res = nums[0];

        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mintemp = min;
            int maxtemp = max;
            min = Math.min(Math.min(nums[i] * mintemp, nums[i] * maxtemp), nums[i]);
            max = Math.max(Math.max(nums[i] * mintemp, nums[i] * maxtemp), nums[i]);
            if (max > res) {
                res = max;
            }
        }

        return res;
    }
}
