package newyear.leetcode3.notebook;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution2 {

    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int ans = 0;

        s = s.replaceAll(" ", "");
        ans = dfs(s, 0, s.length()-1);

        return ans;
    }

    private int dfs(String s, int start, int end) {
        if(start > end){
            return 0;
        }
        int ans = 0;
        int symbol = 1;
        while (start <= end){
            char c = s.charAt(start);
            if(c == '('){
                int leftClo = 1;
                int temp = start;
                start++;
                while (start <= end){
                    char ch = s.charAt(start);
                    if (ch == '(') {
                        leftClo++;
                    }else if(ch == ')'){
                        leftClo--;
                        if(leftClo == 0){
                           break;
                        }
                    }
                    start++;
                }
                ans += symbol * dfs(s, temp+1, start-1);
                start++;
            }else if (c == '+'){
                symbol = 1;
                start++;
            }else if(c == '-'){
                symbol = -1;
                start++;
            }else {
                int temp = 0;
                while (start <= end){
                    char ch = s.charAt(start);
                    if(ch == '+' || ch == '-'){
                        ans += symbol * temp;
                        break;
                    }
                    temp = temp * 10 + (ch - '0');
                    start++;
                }
                if(start == end + 1){
                    ans += symbol * temp;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int calculate = new Solution2().calculate(" 2-1 + 2 ");
        System.out.println(calculate);
    }
}
