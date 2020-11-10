package leetcode11;

import java.util.Arrays;

public class Solution26 {

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return;
        }
        int length  =nums.length;
        int index = -1;
        for (int i = length-2; i >= 0 ; i--) {
            if(nums[i] <nums[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            int left = 0;
            int right = length-1;
            while (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            return;
        }
        Arrays.sort(nums, index+1,length);
        for (int i = index+1; i <length ; i++) {
            if(nums[i] > nums[index]){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
    }
}
