package leetcode5;

import java.util.Stack;

public class Solution5 {

    /*
        使用栈数据结构，遍历一遍，即可？
        有效括号会因为选取的段不同而改变吗？
        如果两个有效段连着，呐可以看作一种，如果不连着，是怎么也连不到一起吗？
        难点在左括号多余情况下的判断是否连续问题？
        如果是右括号，则直接拆分开。
     */
//    public int longestValidParentheses(String s) {
//        if(s == null || s.length() == 0){
//            return 0;
//        }
//        int res = 0;
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i = 0; i <s.length() ; i++) {
//            if(s.charAt(i) == '('){
//                linkedList.push(i+1);
//            }else {
//                if(!linkedList.isEmpty() && linkedList.peek() > 0){
//                    linkedList.pop();
//                }else {
//                    linkedList.push(-(i+1));
//                }
//            }
//        }
//        int temp = s.length()+1;
//        while (!linkedList.isEmpty()){
//            int a = linkedList.pop();
//            a = a>0?a:-a;
//            res = Math.max(res, temp-a-1);
//            temp = a;
//        }
//        res = Math.max(res, temp-1);
//        return res;
//    }

    public static void main(String[] args) {
        String str = "))))";
        int res = new Solution5().longestValidParentheses(str);
        System.out.println(res);
    }

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        //哨兵
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    //匹配到的是最底层那个，即是一个右括号，不计算大小，并把最近这个右括号的下班入栈
                    stack.push(i);
                } else {
                    //匹配到的是一个左括号，有效，计算大小。
                    //有效段的最后一个的下标-有效段最前一个的前一个的下标
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
