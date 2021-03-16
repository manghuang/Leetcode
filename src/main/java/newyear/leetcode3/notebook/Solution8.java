package newyear.leetcode3.notebook;

import java.util.Arrays;
import java.util.Comparator;

public class Solution8 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
//        int[] dp = new int[length];
//        Arrays.fill(dp, 1);
//        int ans = 1;
//        for (int i = 1; i < length; i++) {
//            int temp = 1;
//            for (int j = i-1; j >= 0 ; j--) {
//                if(nums[i] > nums[j]){
//                    temp = Math.max(temp, dp[j]+1);
//                }
//            }
//            dp[i] = temp;
//            ans = Math.max(ans, temp);
//        }
//        return ans;
        int[] dp = new int[length+1];
        int maxLen = 1;
        dp[1] = nums[0];
        for (int i = 1; i < length; i++) {
            if(nums[i] > dp[maxLen]){
                maxLen++;
                dp[maxLen] = nums[i];
            }else {
                // 二分查找找的是刚好大于dp[i], 小于等于dp[i+1]的i
                int left = 1;
                int right = maxLen;
                int pos = 0;
                while (left <= right){
                    int mid = (left + right) / 2;
                    if(nums[i] > dp[mid] ){
                        pos = mid;
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
                }
                dp[pos+1] = nums[i];
            }
        }
        return maxLen;
    }

    // 最长上升子序列
    // O(n2)复杂度，如何优化？贪心算法
    // 一维：正序
    // 二维: 排序第一维正序，第二维倒序
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length == 0) {
            return 0;
        }
        int length = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int ans = 1;

        for (int i = 1; i < length; i++) {
            int temp = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0] &&
                        envelopes[i][1] > envelopes[j][1]) {
                    temp = Math.max(temp, dp[j] + 1);
                }
            }
            dp[i] = temp;
            ans = Math.max(ans, temp);
        }
        return ans;

    }
}
