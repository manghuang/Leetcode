package leetcode11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution27 {

//    private int res = Integer.MAX_VALUE;
    public int findRotateSteps(String ring, String key) {
        if(ring == null || ring.length() == 0 || key == null || key.length() == 0){
            return -1;
        }
        int length = ring.length();
        HashMap<Character, HashSet<Integer>> hashSetHashMap = new HashMap<>();
        for (int i = 0; i <length ; i++) {
            char ch = ring.charAt(i);
            if(hashSetHashMap.containsKey(ch)){
                HashSet<Integer> hashSet = hashSetHashMap.get(ch);
                hashSet.add(i);
            }else {
                HashSet<Integer> hashSet = new HashSet<>();
                hashSet.add(i);
                hashSetHashMap.put(ch, hashSet);
            }
        }
//        dfs(hashSetHashMap,length, 0, key, 0, 0);
//        return res+key.length();

        int keyLength = key.length();
        int[][][] dp = new int[keyLength][][];
        for (int i = 0; i <keyLength ; i++) {
            char ch = key.charAt(i);
            HashSet<Integer> hashSet = hashSetHashMap.get(ch);
            dp[i] = new int[hashSet.size()][2];
            if(i == 0){
                int temp  = 0;
                for (int index: hashSet
                     ) {
                    dp[i][temp][0] = index;
                    dp[i][temp][1]  =Math.min(index, length - index);
                    temp++;
                }
            }else {
                int temp = 0;
                for (int index:hashSet
                     ) {
                    dp[i][temp][0] = index;
                    dp[i][temp][1] = Integer.MAX_VALUE;
                    for (int[] last:
                    dp[i-1]) {
                        int abs = Math.abs(last[0] - index);
                        dp[i][temp][1] = Math.min(dp[i][temp][1], last[1] + Math.min(abs, length - abs));
                    }
                    temp++;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int[] last : dp[keyLength-1]
             ) {
            res = Math.min(res, last[1]);
        }
        return res+keyLength;
    }

//    private void dfs(HashMap<Character,HashSet<Integer>> hashSetHashMap,int length,  int lastIndex, String key, int keyIndex, int num) {
//        if(keyIndex == key.length()){
//            res = Math.min(res, num);
//            return;
//        }
//        char ch = key.charAt(keyIndex);
//        HashSet<Integer> hashSet = hashSetHashMap.get(ch);
//        for (int index: hashSet
//             ) {
//            int abs = Math.abs(lastIndex - index);
//            dfs(hashSetHashMap, length, index, key, keyIndex+1, num + Math.min(abs, length-abs));
//        }
//    }
}
