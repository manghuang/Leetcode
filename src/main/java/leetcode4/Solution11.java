package leetcode4;

import java.util.*;


//方式一、dps，时间复杂度高，存在重复计算，优化
//方式二、动态规划
public class Solution11 {
    private HashMap<String, Boolean> hashMap = new HashMap<>();

    public static void main(String[] args) {
        String str = "aaaaaaa";
        List<String> woedDict = new ArrayList<>();
        woedDict.add("aaaa");
        woedDict.add("aaa");
        boolean res = new Solution11().wordBreak(str, woedDict);
        System.out.println(res);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return dps(s, new HashSet<String>(wordDict), 0);
    }

    //dp[i][j] 代表s.subString(i,j)是否可以用List中的字符串进行组合而成,i<=j
//       dp[i][j]  = dp[i][mid] && dp[mid][j]
    //dp[i] 表示字符串s前i个字符组成的字符串 s[0..i-1] 是否可以用List中的字符串进行组合而成
    /*
                0    1   2   3   4
           0    t
           1         t
           2             t
           3                 t
           4                      t
     */
//    public boolean wordBreak(String s, List<String> wordDict) {
//        int length = s.length();
//        boolean[][] dp  = new boolean[length+1][length+1];
//        for(int r=0; r<=length; r++){
//            for(int i=0; i<=length-r; i++){
//                int j=i+r;
//                if(r == 0){
//                    dp[i][j] = true;
//                }else if(r == 1){
//                    dp[i][j] = wordDict.contains(s.substring(i,j));
//                }else {
//                    if(wordDict.contains(s.substring(i, j))){
//                        dp[i][j] = true;
//                    }else {
//                        boolean temp = false;
//                        for (int k =1; k < r; k++){
//                            if(dp[i][k] && dp[k][j]){
//                                temp = true;
//                                break;
//                            }
//                        }
//                        dp[i][j] = temp;
//                    }
//                }
//            }
//        }
////        for (boolean[] b: dp
////             ) {
////            System.out.println(Arrays.toString(b));
////        }
//        return dp[0][length];
//    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> wordDictSet = new HashSet<>(wordDict);
//        boolean[] dp = new boolean[s.length()+1];
//        for (int i = 1; i < dp.length; i++) {
//            if(wordDictSet.contains(s.substring(0,i))){
//                dp[i] = true;
//            }else {
//                for (int j=1; j<i; j++){
//                    if(dp[j] && wordDictSet.contains(s.substring(j,i))){
//                        dp[i] = true;
//                        break;
//                    }
//                }
//            }
//        }
//        return dp[dp.length-1];
//    }

    private boolean dps(String s, Set<String> wordDict, int frontIndex) {
        if (wordDict.contains(s) || frontIndex >= s.length()) {
            return true;
        }
        for (int endIndex = frontIndex + 1; endIndex <= s.length(); endIndex++) {
            String sub = s.substring(frontIndex, endIndex);
            if (wordDict.contains(sub)) {
                if (hashMap.containsKey(sub)) {
                    if (hashMap.get(sub)) {
                        return true;
                    }
                } else {
                    if (dps(s, wordDict, endIndex)) {
                        hashMap.put(sub, true);
                        return true;
                    } else {
                        hashMap.put(sub, false);
                    }
                }
            }
        }
//        hashMap.put(s.substring(frontIndex, s.length()),false);
        return false;
    }
}

