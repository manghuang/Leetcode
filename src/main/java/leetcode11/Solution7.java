package leetcode11;

import java.util.Arrays;

public class Solution7 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length = nums.length;
        int[] temp = Arrays.copyOf(nums, length);
        Arrays.sort(temp);
        int[] res = new int[length];
        for(int i=0; i<length; i++){
            int index = 0;
            for (int j = 0; j <length ; j++) {
                if(nums[i] ==temp[j]){
                    index = j;
                    break;
                }
            }
            res[i] = index;
        }
        return res;
    }
}
