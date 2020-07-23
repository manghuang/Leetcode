package leetcode3;

public class Solution4 {
    /*
        数组中可能有零，同时不允许除法，所以使用左右乘法列表
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] res = new int[length];

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                left[i] = 1;
                right[length - 1 - i] = 1;
            } else {
                left[i] = left[i - 1] * nums[i - 1];
                right[length - 1 - i] = right[length - i] * nums[length - i];
            }
        }
        for (int i = 0; i < length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
