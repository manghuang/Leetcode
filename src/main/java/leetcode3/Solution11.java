package leetcode3;

import java.util.HashMap;

public class Solution11 {

    /*
       使用一个hashmap来记录一个数得权重
     */
    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        int res = new Solution11().getKth(12, 15, 2);
        System.out.println(res);
    }

    public int getKth(int lo, int hi, int k) {

        for (int i = lo; i <= hi; i++) {
            dps(i, 0, i);
        }
        int[] res = new int[hi - lo + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + lo;
        }
        sort(res);
        return res[k - 1];
    }

    private void dps(int num, int weight, int nowNum) {
        if (nowNum == 1) {
            hashMap.put(num, weight);
            return;
        }
        if (hashMap.containsKey(nowNum)) {
            hashMap.put(num, hashMap.get(nowNum) + weight);
            return;
        }
        if (nowNum % 2 == 0) {
            dps(num, weight + 1, nowNum / 2);
        } else {
            dps(num, weight + 1, 3 * nowNum + 1);
        }
    }

    private void sort(int[] res) {
        int length = res.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j >= 1; j--) {
                if (hashMap.get(res[j]) < hashMap.get(res[j - 1])) {
                    int a = res[j];
                    res[j] = res[j - 1];
                    res[j - 1] = a;
                } else {
                    break;
                }
            }
        }
    }

}
