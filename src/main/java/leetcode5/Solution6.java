package leetcode5;


public class Solution6 {

    public static void main(String[] args) {
        String str1 = "aa";
        String str2 = "a*";
        boolean res = new Solution6().isMatch(str1, str2);
        System.out.println(res);
    }

    /*
        方式一：使用类库中的正则表达式，不可以
        方式二：动态规划
        方式三：dps,回溯，超时，存在重复计算，需要加入一个容器来记录已经计算过的结果
        方式四：贪心算法

     */
//    public boolean isMatch(String s, String p) {
//        //如果为null
//        if(s == null || p == null){
//            return false;
//        }
//        //如果存在空
//        int sLength = s.length();
//        int pLength = p.length();
//        if(sLength == 0 && pLength == 0){
//            return true;
//        }else if(sLength == 0){
//            for (int i = 0; i <p.length() ; i++) {
//                if(p.charAt(i) != '*'){
//                    return false;
//                }
//            }
//            return true;
//        }else  if(pLength == 0){
//            return false;
//        }
//        //都不为空
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(p.charAt(0));
//        for (int i = 1; i < pLength ; i++) {
//            if(p.charAt(i) == '*' && p.charAt(i-1) == '*'){
//                continue;
//            }
//            stringBuilder.append(p.charAt(i));
//        }
////        System.out.println(stringBuilder.toString());
//        /*
//            遍历p:
//                遇到a-z
//                遇到?
//                遇到*
//         */
//        p = stringBuilder.toString();
//        System.out.println(sLength);
//        System.out.println(pLength);
//        return dps(s,0,p,0, 0);
//    }
//
//    private boolean dps(String s, int sIndex, String p, int pIndex, int depth) {
////        System.out.println(sIndex + "/ "+ pIndex);
//        int sLength = s.length()-sIndex;
//        int pLength = p.length()-pIndex;
//        if(sLength == 0 && pLength == 0){
//            return true;
//        }else if(sLength == 0){
//            return "*".equals(p.substring(pIndex));
//        }else  if(pLength == 0){
//            return false;
//        }
//        char ch = p.charAt(pIndex);
//        if(ch <= 'z' && ch >= 'a'){
//            if (s.charAt(sIndex) == ch){
//                return dps(s, sIndex+1, p, pIndex+1, depth+1);
//            }else {
//                return false;
//            }
//        }else if(ch == '?'){
//            return dps(s, sIndex+1, p, pIndex+1, depth+1);
//        }else {
//            System.out.println(sIndex + "  " + pIndex+ "  " + depth);
//            for (int i = sIndex; i <=s.length() ; i++) {
//                boolean res = dps(s, i, p, pIndex + 1, depth+1);
//                if(res){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    /*
        dp[i][j]:s的前i个的子串和p的前j个的子串能否匹配
    */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int slength = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            if (i == 0) {
                stringBuilder.append(p.charAt(i));
                continue;
            }
            if (p.charAt(i) == '*' && p.charAt(i - 1) == '*') {
                continue;
            }
            stringBuilder.append(p.charAt(i));
        }
        p = stringBuilder.toString();
        int pLength = p.length();
        boolean[][] dp = new boolean[slength + 1][pLength + 1];
        /*
            都为0， true
            sLength=0, 视情况而定，
            pLength=0, false
         */
        dp[0][0] = true;
        if (pLength > 0 && p.charAt(0) == '*') {
            dp[0][1] = true;
        }
        for (int i = 1; i < slength + 1; i++) {
            for (int j = 1; j < pLength + 1; j++) {
                char ch = p.charAt(j - 1);
                if (ch == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (ch == '*') {
//                    int k=i;
//                    while (k >=0 && !dp[i][j]){
//                        dp[i][j] = dp[i][j] || dp[k][j-1];
//                        k--;
//                    }
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == ch);
                }
            }
        }

        return dp[slength][pLength];
    }

}
