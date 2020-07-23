package leetcode0;

public class Solution {
    public static void main(String[] args) {
        String str = "aaabaaa";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'a') {
                System.out.println("并不是全a");
                System.out.println(str.charAt(i));
            }
        }
        System.out.println(str.length());
        str = new Solution().longestPrefix(str);
        System.out.println(str.length());
    }

    public String longestPrefix(String s) {
        int[] next = getNext(s);
        int n = next[s.length()];
        return s.substring(0, n);
    }
    //i     0  1  2  3  4  5  6
    //str   a  a  a  b  a  a
    //j -1  0  1  2

    //  0   1  2  3  4  5  6
    // -1   0  1  2  0  1  2

    int[] getNext(String s) {
        int[] next = new int[s.length() + 1];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < s.length()) {
            if (j == -1 || s.charAt(j) == s.charAt(i))
                // 已有 [0, ..., j - 1] 与 [i - j, ..., i - 1] 匹配, 同时 s[j] == s[i]
                next[++i] = ++j;
                // 匹配长度增加 1, 查看下一个匹配位置
            else
                j = next[j];
            // 不匹配, 说明当前查看的前缀太长, 将 j 跳回到上一个可能的匹配位置
        }
        return next;
    }
}
