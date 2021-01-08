package leetcode15;

import java.util.Arrays;

public class Solution3 {



    /*
        方法一：另开一个数组,空间复杂度O(n)，时间复杂度O(n)
        方法二：空间复杂度O(1)，时间复杂度O(n)
     */
//    public void rotate(int[] nums, int k) {
//        if(nums == null || nums.length == 0 || k < 0){
//            return;
//        }
//        int length = nums.length;
//        int[] temp = new int[length];
//        for (int i = 0; i < length; i++) {
//            temp[(i+k) % length] = nums[i];
//        }
//        System.arraycopy(temp, 0, nums, 0, length);
//
//    }

//    public void rotate(int[] nums, int k) {
//        if(nums == null || nums.length <= 1 || k == 0){
//            return;
//        }
//        int length = nums.length;
//        k = k % length;
//        int firstIndex = 0;
//        int outNum = nums[firstIndex];
//        int nextIndex = firstIndex + k ;
//        int count = 0;
//        while (count < length){
//            if(nextIndex != firstIndex){
//                int temp = nums[nextIndex];
//                nums[nextIndex] = outNum;
//                outNum = temp;
//                nextIndex = (nextIndex + k) % length;
//            }else {
//                nums[firstIndex] = outNum;
//                firstIndex++;
//                if (firstIndex == length){
//                    break;
//                }
//                outNum = nums[firstIndex];
//                nextIndex = (firstIndex + k) % length;
//            }
//            count++;
//        }
//    }

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k == 0){
            return;
        }
        int length = nums.length;
        k = k % length;
        reverse(nums, 0, length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, length-1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        new Solution3().rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
