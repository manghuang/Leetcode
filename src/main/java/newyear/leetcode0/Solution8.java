package newyear.leetcode0;

import java.util.*;

public class Solution8 {


    // 区别于：不重复字符的最长子串  滑动窗口，以right为边界，调整left
    // 至少K个重复字符的最长子串
    // 分治
    // 以一个二元组记录当前位置处：每个字母出现的（最后一个位置，个数） 从左到右，从右到左，有问题

//    public int longestSubstring(String s, int k) {
//        int length = s.length();
//        int[][] chToIntNum = new int[26][2];
//        for (int i = 0; i < 26; i++) {
//            chToIntNum[i][0] = -1;
//        }
//        for (int i = 0; i < length; i++) {
//            dfs(s, 0, i, k);
//        }
//
//    }
//

//    public int longestSubstring(String s, int k) {
//        int length = s.length();
//        return dfs(s, 0, length-1, k);
//    }
//    private int dfs(String s, int left, int right, int k) {
//        if(left > right){
//            return 0;
//        }
//        int[] chToIntNum = new int[26];
//        for (int i = left; i <=right ; i++) {
//            int chToInt = s.charAt(i) - 'a';
//            chToIntNum[chToInt]++;
//        }
//        char split = 0;
//        for (int i = 0; i < 26; i++) {
//            if(chToIntNum[i] == 0 || chToIntNum[i] >= k){
//                continue;
//            }
//            split = (char) (i + 'a');
//            break;
//        }
//        if(split == 0){
//            return right - left + 1;
//        }
//        int ans = 0;
//        int index = left;
//        while (index <= right){
//            while (index <= right && s.charAt(index) == split){
//                index++;
//            }
//            if(index > right){
//                break;
//            }
//            int start = index;
//            while (index <= right && s.charAt(index) != split){
//                index++;
//            }
//            ans = Math.max(ans, dfs(s, start, index-1, k));
//        }
//        return ans;
//    }
}
