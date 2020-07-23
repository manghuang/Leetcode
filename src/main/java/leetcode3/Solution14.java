package leetcode3;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = commonPrefix(res, strs[i]);
        }
        return res;
    }

    private String commonPrefix(String str1, String str2) {
        int right = 0;
        while (right < str1.length() && right < str2.length()) {
            if (str1.charAt(right) == str2.charAt(right)) {
                right++;
            } else {
                break;
            }
        }
        return str1.substring(0, right);
    }
}
