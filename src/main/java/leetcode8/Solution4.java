package leetcode8;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    /*
        方法一：dps+回溯+剪枝
                边界条件和剪枝条件不一样，剪枝条件更严格

     */
    private List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution4().combine(4, 2);
        for (List<Integer> list : combine) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combine(int n, int k) {

        if (k <= 0 || k > n) {
            return this.res;
        }
        List<Integer> list = new ArrayList<>(k);
        dps(1, n, k, list);
        return this.res;
    }

    private void dps(int left, int n, int k, List<Integer> list) {
        int size = list.size();
        if (size == k) {
            ArrayList<Integer> temp = new ArrayList<>(list);
            this.res.add(temp);
            return;
        }
        if ((n - left + 1) < (k - size)) {
            return;
        }
        list.add(left);
        dps(left + 1, n, k, list);
        list.remove(list.size() - 1);
        dps(left + 1, n, k, list);

    }


}
