package leetcode10;

public class Solution7 {

    public int maxPower(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int res = 1;
        int temp = 1;
        char ch = s.charAt(0);
        int length = s.length();
        for (int i = 1; i < length; i++) {
            if(ch == s.charAt(i)){
                temp++;
            }else {
                res = Math.max(res, temp);
                temp = 1;
                ch = s.charAt(i);
            }
        }
        res = Math.max(res, temp);
        return res;
    }
}
