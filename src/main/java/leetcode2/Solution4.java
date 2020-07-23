package leetcode2;

import java.util.Arrays;

public class Solution4 {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new Solution4().longestPalindrome(s));
    }

    //暴力，枚举所有字串，找符合条件的最长字串
    //动态规划
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int length = s.length();
        boolean[][] isHuiWen = new boolean[length][];
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < length; i++) {
            isHuiWen[i] = new boolean[length];
            Arrays.fill(isHuiWen[i], false);
        }

        for (int num = 0; num < length; num++) {
            for (int i = 0; i < length; i++) {
                int j = i + num;
//                System.out.println(i + "," + j);
                if (j >= length) {
                    break;
                }
                if (num == 0) {
                    isHuiWen[i][j] = true;
                } else if (num == 1) {
                    isHuiWen[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    isHuiWen[i][j] = isHuiWen[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
                if (isHuiWen[i][j] && (num + 1) > (endIndex - startIndex)) {
                    startIndex = i;
                    endIndex = j + 1;
                }
            }
        }
//        System.out.println("____________");
//        for (int i = 0; i <length ; i++) {
//            for (int j = 0; j <length ; j++) {
//                System.out.print(isHuiWen[i][j] + "   ");
//            }
//            System.out.println();
//        }
//        for(int num=0; num<length; num++){
//            for(int i=0; i<length; i++){
//                int j=length-1-num+i;
////                System.out.println(i + "," + j);
//                if(j >= length){
//                    break;
//                }
//                if(isHuiWen[i][j]){
//                    return s.substring(i, j+1);
//                }
//            }
//        }
        return s.substring(startIndex, endIndex);
    }


//    public String longestPalindrome(String s) {
//        if(s == null || s.length() ==0 ){
//            return s;
//        }
//        int start = 0;
//        int end = 0;
//        int length = 0;
//        for(int i=0; i<s.length(); i++){
//            if(s.length() - i < length){
//                break;
//            }
//            for(int j=i+1; j<s.length(); j++){
//                if((j-i) >length && isHuiWen(s, i, j)){
//                    start = i;
//                    end = j;
//                    length = j- i;
//                }
//            }
//        }
//        return s.substring(start, end+1);
//    }

//    private boolean isHuiWen(String s, int i, int j) {
//        while (i<j){
//            if(s.charAt(i) != s.charAt(j)){
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
}
