package leetcode2;

import java.util.HashMap;

public class Solution9 {
    public static void main(String[] args) {
        int[] a = {-1, 2, 9};
        int res = new Solution9().subarraysDivByK(a, 2);
        System.out.println(res);
    }

    //暴力:枚举所有子串，判断是否满足条件
    //动态规划（不可以）,找不到状态和状态转移方程
    /*前缀和，每一个下标处对应一个状态（%K)
     *  找最长
     *  找最短
     *  找个数
     */
    public int subarraysDivByK(int[] A, int K) {
//        if(A == null || A.length == 0){
//            return 0;
//        }
//        int res = 0;
//        for (int i = 0; i < A.length; i++) {
//            int subSum = 0;
//            for(int j=i; j<A.length; j++){
//                subSum += A[j];
//                if(subSum % K == 0){
//                    res++;
//                }
//            }
//        }
        // -2 4         7
        // -1 2 9       2
        //0 -1  1  0
        //0 -2  2
        //a % k = x
        //b % k =y
        //(a+b) % k =()
        if (A == null || A.length == 0) {
            return 0;
        }
        int res = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int subSum = 0;
        for (int num : A
        ) {
            subSum += num;
            int temp = subSum % K;
            if (temp < 0) {
                temp = temp + K;
            }
            if (hashMap.containsKey(temp)) {
                int a = hashMap.get(temp);
                res += a;
                hashMap.put(temp, a + 1);
            } else {
                hashMap.put(temp, 1);
            }
        }

        return res;
    }
}
