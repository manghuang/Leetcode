package newyear.leetcode3.notebook;

public class Solution11 {

    //    public int getLongestPalindrome(String A, int n) {
//        // write code here
//        if(A == null || n == 0){
//            return 0;
//        }
//        if(n == 1){
//            return 1;
//        }
//        int ans = 1;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <= i; j++) {
//                if(isOk(A, j, i)){
//                    ans = Math.max(ans, i-j+1);
//                }
//            }
//        }
//
//        return ans;
//    }
//
//    private boolean isOk(String a, int start, int end) {
//        while (start <= end){
//            if(a.charAt(start) != a.charAt(end)){
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }
    public int getLongestPalindrome(String A, int n) {
        if(n == 0){
            return 0;
        }
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int ans = 1;
        for(int rou=1; rou < n; rou++){
            for (int i = 0; i < n-rou; i++) {
                int j=i+rou;
                if(A.charAt(i) == A.charAt(j)){
                    if(i+2-j > 0){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if(dp[i][j]){
                        ans = Math.max(ans, j-i+1);

                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new Solution11().getLongestPalindrome("baabccc", 7);
        System.out.println(ans);
    }
}
