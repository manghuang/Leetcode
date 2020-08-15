package leetcode7;

import java.util.LinkedList;

public class Solution4 {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                linkedList.push(ch);
            } else {
                if (linkedList.isEmpty()) {
                    return false;
                } else {
                    char left = linkedList.pop();
                    if ((ch == ')' && left == '(') || (ch == ']' && left == '[') || (ch == '}' && left == '{')) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return linkedList.isEmpty();
    }

}
