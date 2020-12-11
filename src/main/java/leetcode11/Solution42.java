package leetcode11;

import java.util.*;

public class Solution42 {
    public String reorganizeString(String S) {
        if(S == null || S.length() <= 1){
            return S;
        }
//        char[] chars = S.toCharArray();
//        int length = chars.length;
//        for (int i = 1; i <length ; i++) {
//            if(chars[i] == chars[i-1]){
//                int index = -1;
//                for (int j = i+1; j <length ; j++) {
//                    if(chars[j] != chars[i]){
//                        index = j;
//                        break;
//                    }
//                }
//                if(index == -1){
//                    return "";
//                }else {
//                    char ch = chars[i];
//                    chars[i] = chars[index];
//                    chars[index] = ch;
//                }
//            }
//        }

//        return String.valueOf(chars);
        int[] chars = new int[26];
        int length = S.length();
        int maxCount = 0;
        for (int i = 0; i <length ; i++) {
            char ch = S.charAt(i);
            chars[ch-'a']++;
            maxCount =Math.max(maxCount, chars[ch-'a']);
        }
        if(maxCount<<1 > length+1){
            return "";
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return chars[o2] - chars[o1];
            }
        });
        for (int i = 0; i <26 ; i++) {
            if(chars[i] != 0){
                priorityQueue.add(i);
            }
        }
        StringBuilder res = new StringBuilder();
        while (priorityQueue.size() >1){
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            res.append((char)(first + 'a'));
            res.append((char)(second + 'a'));
            chars[first]--;
            chars[second]--;
            if(chars[first]!= 0){
                priorityQueue.add(first);
            }
            if(chars[second] != 0){
                priorityQueue.add(second);
            }
        }
        if(priorityQueue.size() != 0){
            int first = priorityQueue.poll();
            res.append((char)(first + 'a'));
        }
        return res.toString();
    }
}
