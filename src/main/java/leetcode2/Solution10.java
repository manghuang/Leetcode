package leetcode2;

import java.util.LinkedList;

public class Solution10 {
    public static void main(String[] args) {
        String str = "3[a2[c]]";
        String res = new Solution10().decodeString(str);
        System.out.println(res);
    }

    public String decodeString(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder ans = new StringBuilder();
        LinkedList<Integer> multStack = new LinkedList<>();
        LinkedList<StringBuilder> ansStack = new LinkedList<>();
        int mult = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                mult = mult * 10 + (c - '0');
            } else if (c == '[') {
                ansStack.push(ans);
                multStack.push(mult);
                ans = new StringBuilder();
                mult = 0;
            } else if (Character.isAlphabetic(c)) {
                ans.append(c);
            } else {
                StringBuilder tempStr = ansStack.pop();
                int tempNum = multStack.pop();
                for (int i = 0; i < tempNum; i++) {
                    tempStr.append(ans);
                }
                ans = tempStr;
            }
        }
        return ans.toString();
    }

}
