package leetcode8;

import java.util.ArrayList;
import java.util.List;

public class Solution7 {

    /*
        一个数组，里面的数字不可以重复，不可以重复使用，选择其中的数组成target,个数有限
        dps+回溯+剪枝
     */

    private List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution7().combinationSum3(3, 7);
        for (List<Integer> list : lists
        ) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n <= 0 || n > 45 || k <= 0 || k > 9) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        dps(k, n, list, 9, 0);
        return res;
    }

    private void dps(int k, int n, List<Integer> list, int maxNum, int sum) {
        if (k == 0 && sum == n) {
            List<Integer> temp = new ArrayList<>(list);
            res.add(temp);
            return;
        }
        if (k < 0 || sum > n || maxNum <= 0) {
            return;
        }
        int num = sum + k * (k + 1) / 2;
        if (num > n) {
            return;
        }

        for (int i = maxNum; i >= 1; i--) {
            list.add(i);
            dps(k - 1, n, list, i - 1, sum + i);
            list.remove(list.size() - 1);
        }
        return;
    }

}
