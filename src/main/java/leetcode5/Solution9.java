package leetcode5;

public class Solution9 {

    /*
        思路：2的k次方
        实际：k的范围  0-k
    */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] res = new int[k + 1];
        int temp = longer + shorter;
        res[0] = shorter * k;
        for (int i = 1; i <= k; i++) {
//            res[i] = longer*i + shorter*(k-i);
            res[i] = res[i - 1] + temp;
        }
        return res;
    }

}
