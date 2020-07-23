package leetcode0;

import java.util.Arrays;

class Solution2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        new Solution2().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                //this.exchange(nums, i , i-1);
                //现在已知的[i, length-1]按降序排练，同时nums[i]>nums[i-1]，那么只要从[i, length-1]中选出大于且最接近nums[i-1]的数字进行交换即可
                int index = i;
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int a = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = a;
                        Arrays.sort(nums, i, nums.length);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums, 0, nums.length);
        return;
    }
}