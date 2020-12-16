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
}
