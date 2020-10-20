package leetcode11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution2 {
    /*
        方法一：枚举所有的可能数组，对他们进行判断，直到得到一个漂亮数组为止
               O(n!*n3)
        方法二：
     */
    private  int[] res;
    private int n;
    public int[] beautifulArray(int N) {
        if(N <= 0){
            return null;
        }
        res = new int[N];
        n = N;
        HashSet<Integer> remainNums = new HashSet<>();
        for (int i = 1; i <= N ; i++) {
            remainNums.add(i);
        }
        dps(0, remainNums);
        return res;
    }

    private boolean dps(int index, HashSet<Integer> remainNums) {
        if(index == n){
            return true;
        }
        // 遍历集合过程中对集合进行增删
        HashSet<Integer> hashSet = new HashSet<>(remainNums);
        for (int num : hashSet) {
            res[index] = num;
            remainNums.remove(num);
            if (isok(index, remainNums)) {
                if(dps(index + 1, remainNums)){
                    return true;
                }
            }
            remainNums.add(num);
        }
        return false;
    }

    private boolean isok(int index, HashSet<Integer> remainNums) {
        if(index == 0){
            return true;
        }
        for (int i = 0; i < index ; i++) {
            int temp = 2*res[index]-res[i];
            if(remainNums.contains(temp)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] res = new Solution2().beautifulArray(4);
        System.out.println(Arrays.toString(res));
    }


}
