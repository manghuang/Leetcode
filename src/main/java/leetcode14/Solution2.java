package leetcode14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.trim().split(" ");
        int length = strs.length;
        if(pattern.length() != length){
            return false;
        }
        System.out.println(Arrays.toString(strs));
        Map<Character, Integer> mapP = new HashMap<>();
        Map<String, Integer> mapS = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            if(mapP.containsKey(pattern.charAt(i))){
                if(mapS.containsKey(strs[i])){
                    if(!mapP.get(pattern.charAt(i)).equals(mapS.get(strs[i]))){
                        return false;
                    }
                }else {
                    return false;
                }
            }else {
                if(mapS.containsKey(strs[i])){
                    return false;
                }else{
                    mapP.put(pattern.charAt(i), i);
                    mapS.put(strs[i], i);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = new Solution2().wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd",
                "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t");
        System.out.println(res);
    }

    public String solve (String s, String t) {
        // write code here
        if(s == null || s.length() == 0){
            return t;
        }
        if(t == null || t.length() == 0){
            return s;
        }
        int sIndex = s.length()-1;
        int tIndex = t.length()-1;
        int temp = 0;
        StringBuilder strBuil = new StringBuilder();
        while(sIndex >= 0 && tIndex >= 0){

            int num1 = s.charAt(sIndex--) - '0';
            int num2 = t.charAt(tIndex--) - '0';
            int res = num1 + num2 + temp;
            if(res >= 10){
                temp = 1;
                res -= 10;
            }else{
                temp = 0;
            }
            strBuil.append((char)(res + '0'));
        }
        while(sIndex >= 0){
            if(temp  == 0){
                strBuil.append(s.charAt(sIndex--));
            }else{
                int res = s.charAt(sIndex--) - '0';
                res += temp;
                if(res >= 10){
                    temp = 1;
                    res -= 10;
                }else{
                    temp = 0;
                }
                strBuil.append((char)(res + '0'));
            }
        }
        while(tIndex >= 0){
            if(temp == 0){
                strBuil.append(t.charAt(tIndex--));
            }else{
                int res = t.charAt(tIndex--) - '0';
                res += temp;
                if(res >= 10){
                    temp = 1;
                    res -= 10;
                }else{
                    temp = 0;
                }
                strBuil.append((char)(res + '0'));
            }
        }
        if(temp == 1){
            strBuil.append("1");
        }
        strBuil.reverse();
        return strBuil.toString();
    }
}
