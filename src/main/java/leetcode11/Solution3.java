package leetcode11;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if(S == null){
            return res;
        }
        int[] table = new int[26];
        int length = S.length();
        for (int i = length-1; i >= 0 ; i--) {
            int num = S.charAt(i) - 'a';
            if(table[num] == 0){
                table[num] = i;
            }
        }
        int start = 0;
        int end = 0;
        boolean isok = false;
        for (int i = 0; i <length ; i++) {
            int num = S.charAt(i) - 'a';
            if(!isok){
                start = i;
                end = table[num];
                isok = true;

            }
            if(end == i){
                res.add(end - start + 1);
                isok = false;
            }else {
                end = Math.max(end, table[num]);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new Solution3().partitionLabels("caedbdedda");
        System.out.println(res);
    }
}
