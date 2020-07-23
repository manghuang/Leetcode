package leetcode3;

public class Solution12 {

    /*
      方式一：递归+dps
      方式二：迭代+动态规划
     */
//    private HashMap<Integer, Integer> hashMap = new HashMap<>();
//    public int climbStairs(int n) {
//        if(n <= 0){
//            return 0;
//        }
//        return  dps(n);
//    }
//
//    private int dps(int n) {
//        if(n<=0){
//            return 0;
//        }else if(n==1){
//            return 1;
//        }else if(n==2){
//            return 2;
//        }else {
//            if(hashMap.containsKey(n-1) && hashMap.containsKey(n-2)){
//                return hashMap.get(n-1)+hashMap.get(n-2);
//            }else if(hashMap.containsKey(n-1)){
//                int a = dps(n-2);
//                hashMap.put(n-2, a);
//                return hashMap.get(n-1)+a;
//            }else if(hashMap.containsKey(n-2)){
//                int a = dps(n-1);
//                hashMap.put(n-1,a);
//                return hashMap.get(n-2)+a;
//            }else {
//                int a = dps(n-1);
//                int b = dps(n-2);
//                hashMap.put(n-1,a);
//                hashMap.put(n-2,b);
//                return a+b;
//            }
//        }
//    }

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
