package leetcode2;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Solution11 {
    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    //具体分析，讨论不同情况，跳1或者跳2，从0下标或者1下标开始，dps
    /*
       0 1 2 3 4 5 6 7 8 9 10 11 12 13

       0   2   4   6   8   10    12
       0     3   5   7   9    11    13
       0     3     6   8   10    12
         1   3   5   7   9    11    13
         1     4   6   8   10    12
         1     4     7   9    11    13
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int case1 = dps(nums, 0);
        int case2 = dps(nums, 1);
        return Math.max(case1, case2);
    }

    private int dps(int @NotNull [] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int case1;
        int case2;
        if (hashMap.containsKey(index + 2)) {
            case1 = hashMap.get(index + 2);
        } else {
            case1 = dps(nums, index + 2);
            hashMap.put(index + 2, case1);
        }
        if (hashMap.containsKey(index + 3)) {
            case2 = hashMap.get(index + 3);
        } else {
            case2 = dps(nums, index + 3);
            hashMap.put(index + 3, case2);
        }
        return nums[index] + Math.max(case1, case2);
    }

}
