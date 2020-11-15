package leetcode11;

import java.util.Arrays;

public class Solution33 {


    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0){
            return "";
        }
        if(k < 0 || k >num.length()){
            return "";
        }
        int length = num.length();
        int index = 0;
//        int[][] dp = new int[length][length];
//        for (int i = 0; i <length ; i++) {
//            dp[i][i] = num.charAt(i) - '0';
//        }
//        for (int r = 1; r <length ; r++) {
//            for (int i = 0; i <length-r ; i++) {
//                int j=i+r;
//                dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]);
//            }
//        }
        boolean[] isDel = new boolean[length];
        Arrays.fill(isDel, 0, k, true);
        for (int i = k; i <length ; i++) {
            int minVal = num.charAt(index);
            int minIndex = index;
            for (int j = index+1; j <= i; j++) {
                if(num.charAt(j) < minVal){
                    minVal = num.charAt(j);
                    minIndex = j;
                }
            }
            if(minIndex == i){
                break;
            }else {
                isDel[minIndex] = false;
                isDel[i] = true;
                index = minIndex+1;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        boolean begin = false;
        for (int i = 0; i <length ; i++) {
            if(!isDel[i]){
                if(begin){
                    stringBuilder.append(num.charAt(i));
                }else {
                    if(num.charAt(i) != '0'){
                        begin = true;
                        stringBuilder.append(num.charAt(i));
                    }
                }
            }
        }
        if(stringBuilder.length() == 0){
            stringBuilder.append('0');
        }
        return stringBuilder.toString();
    }
}
