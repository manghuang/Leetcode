package newyear.leetcode0;

import java.util.Arrays;
import java.util.HashMap;

public class Solution5 {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int length = s.length();
//        int[] chLastIndexs = new int[26];
//        Arrays.fill(chLastIndexs, -1);
        HashMap<Character, Integer> map = new HashMap<>();
        int left = -1;
        int ans = 0;

        for (int right = 0; right < length; right++) {
            char ch = s.charAt(right);
//            if(chLastIndexs[ch - 'a'] <= left){
//                chLastIndexs[ch - 'a'] = right;
//            }else {
//                left = chLastIndexs[ch - 'a'];
//                chLastIndexs[ch - 'a'] = right;
//            }
            if(map.containsKey(ch)){
                if(map.get(ch) > left){
                    left = map.get(ch);
                }
            }
            map.put(ch, right);
            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}
