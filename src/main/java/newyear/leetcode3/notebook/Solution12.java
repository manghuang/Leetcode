package newyear.leetcode3.notebook;

import java.util.HashMap;

public class Solution12 {

//    public String minWindow (String S, String T) {
//        // write code here
//        HashMap<Character, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < T.length(); i++) {
//            char ch = T.charAt(i);
//            if(hashMap.containsKey(ch)){
//                hashMap.put(ch, hashMap.get(ch)+1);
//            }else {
//                hashMap.put(ch, 1);
//            }
//        }
//        int length = S.length();
//        int[] nextIndex = new int[length];
//        int temp = length;
//        for (int i = length-1; i >= 0 ; i--) {
//            char ch = S.charAt(i);
//            nextIndex[i] = temp;
//            if(hashMap.containsKey(ch)){
//                temp = i;
//            }
//        }
//        int left = 0;
//        int right = 0;
//        int index = 0;
//        while (right < length){
//
//        }
//    }
}
