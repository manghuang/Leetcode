package leetcode14;

import java.util.*;

public class Solution5 {


    /*
        字符串最小序列：单调栈
        其他约束：出现过的类型都要有，多的只取其中一个
     */
    public String removeDuplicateLetters(String s) {
        if(s == null){
            return  "";
        }
        if(s.length() <= 1){
            return s;
        }
        int length = s.length();
        // c b a c d c b c
        //c      c   c   c
        //   b         b
        //     a   d
//        int[] nums = new int[26];
//        boolean[] res = new boolean[length];
//        Arrays.fill(nums, -1);
//        for(int i=0; i<length; i++){
//            int ch = s.charAt(i) - 'a';
//            if(nums[ch] != -1){
//                int index = nums[ch]+1;
//                while (index < i){
//                    if(res[index]){
//                        int nextCh = s.charAt(index) - 'a';
//                        if(ch > nextCh){
//                            res[nums[ch]] = false;
//                            res[i] = true;
//                            nums[ch] = i;
//                        }
//                        break;
//                    }
//                    index++;
//                }
//            }else{
//                nums[ch] = i;
//                res[i] = true;
//            }
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i <length ; i++) {
//            if(res[i]){
//                stringBuilder.append(s.charAt(i));
//            }
//        }
//        return  stringBuilder.toString();
        LinkedList<Character> stack = new LinkedList<>();
        stack.push('a');
        Set<Character> set = new HashSet<>();
        int[] chNum = new int[26];
        for(int i=0; i<length; i++){
            chNum[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<length; i++){
            char ch = s.charAt(i);
            chNum[ch - 'a']--;
            if (set.contains(ch)) {
                continue;
            }
            while (true){
                char last = stack.peek();
                if(last > ch && chNum[last - 'a'] > 0){
                    set.remove(last);
                    stack.pop();
                }else {
                    set.add(ch);
                    stack.push(ch);
                    break;
                }
            }
        }
        StringBuilder res  = new StringBuilder();
        while (stack.size() > 1){
            res.append(stack.pop());
        }
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        String res = new Solution5().removeDuplicateLetters("cbacdcbc");
        System.out.println(res);
    }
}
