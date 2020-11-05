package leetcode11;

import java.util.*;

public class Solution20 {

    /*
        建图过程与判断过程不要耦合，分开清晰
        以下方法是耦合的方法
     */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = wordList.size();
        boolean[] isVisted = new boolean[length];
        LinkedList<String> stack= new LinkedList<>();
        stack.add(beginWord);
        int res = 2;
        while (!stack.isEmpty()){
            int size = stack.size();
            for (int i = 0; i <size ; i++) {
                String temp = stack.remove();
                for (int j = 0; j <length ; j++) {
                    String str = wordList.get(j);
                   if(!isVisted[j] && nextOk(temp, str)){
                       if(Objects.equals(endWord, str)){
                           return res;
                       }
                       isVisted[j] = true;
                       stack.offer(str);
                   }
                }
            }
            res++;
        }
        return 0;
    }

    private boolean nextOk(String src, String target) {
        int length = src.length();
        int difNum = 0;
        for (int i = 0; i <length ; i++) {
            if(src.charAt(i) != target.charAt(i)){
                difNum++;
            }
        }
        return difNum == 1;
    }

    public static void main(String[] args) {

        List<String> lists = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        int res = new Solution20().ladderLength("hit", "cog", lists);
        System.out.println(res);
    }

}
