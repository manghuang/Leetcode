package leetcode10;

import java.util.Arrays;
import java.util.HashSet;

public class Solution11 {

    public int maxVowels(String s, int k) {
        if(s == null){
            return 0;
        }
        int lenght = s.length();
        if(k <= 0 || k > lenght){
            return 0;
        }
        Character[] characters = {'a', 'e', 'i', 'o', 'u'};
        HashSet<Character> hashSet = new HashSet<>(Arrays.asList(characters));
        int[] dp = new int[lenght];
        int res = 0;
        for (int i = 0; i <lenght ; i++) {
            if(i == 0){
                if(hashSet.contains(s.charAt(i))){
                    dp[i]  =1;
                }
                if(k == 1){
                    res = Math.max(res, dp[i]);
                }
            }else if(i <= k-1){
                if(hashSet.contains(s.charAt(i))){
                    dp[i] = dp[i-1]+1;
                }else {
                    dp[i] = dp[i-1];
                }
                if(i == k-1){
                    res = Math.max(res, dp[i]);
                }
            }else {
                boolean left = hashSet.contains(s.charAt(i-k));
                boolean right = hashSet.contains(s.charAt(i));
                if((left && right ) || (!left && !right)){
                    dp[i] = dp[i-1];
                }else if(!left) {
                    dp[i] = dp[i-1]+1;
                    res = Math.max(res, dp[i]);
                }else{
                    dp[i] = dp[i-1] - 1;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution11().maxVowels("aeiou", 2);
        System.out.println(res);
    }
}
