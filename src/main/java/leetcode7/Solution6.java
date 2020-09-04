package leetcode7;

public class Solution6 {

    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        int temp = 0;
        for (int i = length - 1; i > 0; i--) {
            if (isHuiwen(s, i)) {
                temp = i;
                break;
            }
        }
        StringBuilder res = new StringBuilder(s.substring(temp + 1, length));
        return res.reverse().append(s).toString();
    }

    private boolean isHuiwen(String s, int right) {
        int left = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
