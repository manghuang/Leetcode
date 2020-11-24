package leetcode11;

public class Solution39 {

    public boolean isAnagram(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        int[] charNum = new int[26];
        for (int i = 0; i <s.length() ; i++) {
            charNum[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i <t.length() ; i++) {
            charNum[t.charAt(i) - 'a']--;
        }
        for (int num : charNum
             ) {
            if(num != 0){
                return false;
            }
        }
        return true;
    }
}
