package leetcode2;

import java.util.Arrays;

public class Solution3 {
    //暴力：枚举所有字串
    //动态规划 不行
    //前缀和+状态压缩
    public int findTheLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int[] nums = new int[5];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(nums, 0);
            int temp = 0;
            if (s.length() - i < res) {
                break;
            }
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == 'a') {
                    nums[0]++;
                } else if (s.charAt(j) == 'e') {
                    nums[1]++;
                } else if (s.charAt(j) == 'i') {
                    nums[2]++;
                } else if (s.charAt(j) == 'o') {
                    nums[3]++;
                } else if (s.charAt(j) == 'u') {
                    nums[4]++;
                }
                temp++;
                if (temp > res && isok(nums)) {
                    res = temp;
                }
            }
        }

        return res;
    }

    private boolean isok(int[] nums) {
        for (int num : nums) {
            if (num % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
