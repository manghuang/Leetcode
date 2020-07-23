package leetcode4;

import java.util.Arrays;

public class Solution13 {

    /*
        方式一：先排序，后找  时间复杂度高
        方式二：遍历一遍，记录出现的正整数，后找   空间复杂度高
        方式三：使用原来的数组来存储状态
     */
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        int index = 1;
        for (int num : nums
        ) {
            if (num > 0) {
                if (num == index) {
                    index++;
                } else if (num == index - 1) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return index;
    }

}
