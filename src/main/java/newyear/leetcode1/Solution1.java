package newyear.leetcode1;

import java.util.LinkedList;

public class Solution1 {

    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Character> stack2 = new LinkedList<>();

        int length =s.length();
        int temp = 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if(ch == ' '){
                continue;
            }
            if(ch >= '0' && ch <= '9'){
                temp = temp * 10 + (ch - '0');
            }else {
                if(stack2.isEmpty()){
                    stack.push(temp);
                    stack2.push(ch);
                }else {
                    char a = stack2.peek();
                    if(a == '/' || a == '*'){
                        stack2.pop();
                        int last = stack.pop();
                        if(a == '/'){
                            stack.push(last / temp);
                        }else {
                            stack.push(last * temp);
                        }
                        stack2.push(ch);
                    }else {
                        stack.push(temp);
                        stack2.push(ch);
                    }
                }

                temp = 0;
            }
        }
        if (!stack2.isEmpty()){
            char a = stack2.peek();
            if(a == '*'){
                stack2.pop();
                int last = stack.pop();
                stack.push(last * temp);
            }else if(a == '/'){
                stack2.pop();
                int last = stack.pop();
                stack.push(last / temp);
            }else {
                stack.push(temp);
            }
        }else {
            return temp;
        }
        int ans = stack.removeLast();
        while (!stack2.isEmpty()){
            char ch = stack2.removeLast();
            int next = stack.removeLast();
            if(ch == '+'){
                ans = ans + next;
            }else if(ch == '-'){
                ans = ans - next;
            }else if(ch == '*'){
                ans = ans * next;
            }else {
                ans = ans / next;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int calculate = new Solution1().calculate("2+3-4");
        System.out.println(calculate);
    }
}
