package leetcode10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution1 {

    /*
        寻找区间，定义一个开始和结束的指针，来降低时间复杂度
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if(S == null ){
            return res;
        }
        int length = S.length();
        int[] dp = new int[length];
        HashMap<Character, Integer> table = new HashMap<>();
        for (int i=0; i<length; i++){
            char ch = S.charAt(i);
            if(table.containsKey(ch)){
                dp[i] = table.get(ch);
            }else {
                dp[i] = i;
                table.put(ch, i);
            }
        }
//        for (int i = 0; i < length ; i++) {
//            int num = dp[i];
//            for (int j = num+1; j < i; j++){
//                if(dp[j] < dp[i]){
//                    dp[i] = dp[j];
//                }
//            }
//        }
//        int index =length-1;
//        while (index >= 0){
//            int last = dp[index];
//            res.add(index - last +1);
//            index = last-1;
//        }
        int start = length-1, end = length-1;
        for (int i = length-1; i >=0  ; i--) {
            start = Math.min(start, dp[i]);
            if(i == start){
                res.add(end - start +1);
                end = start - 1;
            }
        }
        Collections.reverse(res);

        return res;
    }

}
