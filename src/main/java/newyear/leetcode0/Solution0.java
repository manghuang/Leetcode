package newyear.leetcode0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0 {

    private boolean[][] dp;

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {

        // 表示子串26个字母的奇偶性，使用boolean数组，使用一个int数的不同位数
        dp = new boolean[s.length()][26];
        for (int i = 0; i < s.length(); i++) {
            boolean[] temp = new boolean[26];
            if(i == 0){
                Arrays.fill(temp, true);
            }else {
                System.arraycopy(dp[i-1], 0, temp, 0, 26 );
            }
            int chIndex = s.charAt(i) - 'a';
            temp[chIndex] = !temp[chIndex];
            dp[i] = temp;
        }

        int length = queries.length;
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int k = queries[i][2];
            boolean ans = method(s, left, right, k);
            list.add(ans);
        }
        return list;
    }

    private boolean method(String s, int left, int right, int k) {
        if(right == left){
            return true;
        }
        // 回文串
        // 子串个数为奇数，一个奇数，其余的都是偶数
        // 子串个数为偶数，都是偶数
        int chNumOdomNum = 0;

        // 把这个获得chNumOdomNum的方法替换成更高级的
//        int[] chNum = new int[26];
//        for (int i = left; i <= right ; i++) {
//            char ch = s.charAt(i);
//            chNum[ch - 'a']++;
//        }
//        for (int i = 0; i < chNum.length; i++) {
//            if(chNum[i] % 2 == 1){
//                chNumOdomNum++;
//            }
//        }
        for (int i = 0; i < 26; i++) {
            if(left == 0){
                if(!dp[right][i]){
                    chNumOdomNum++;
                }
            }else{
                if(dp[left-1][i] != dp[right][i]){
                    chNumOdomNum++;
                }
            }
        }

        int needK = chNumOdomNum / 2;
        return k >= needK;
    }

    public static void main(String[] args) {
        String str = "abcda";
        int[][] a = {{0, 4 ,1}};
        List<Boolean> list = new Solution0().canMakePaliQueries(str, a);
        System.out.println(list);
    }
}
