package leetcode8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution5 {

    /*
        如果是两个或者三个数字组成target,集合中的数字只能使用一次且可以重复，使用左右双指针
        这个情况不一样，不能采用上面的思想，要使用dps+回溯
     */
    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {
            return this.res;
        }
        Arrays.sort(candidates);
        dps(candidates, candidates.length - 1, new ArrayList<Integer>(), target, 0);
        return this.res;
    }

    private void dps(int[] candidates, int index, ArrayList<Integer> list, int target, int sum) {
        if (sum == target) {
            ArrayList<Integer> temp = new ArrayList<>(list);
            this.res.add(temp);
            return;
        }
        if (index < 0 || sum > target) {
            return;
        }

        for (int i = index; i >= 0; i--) {
            list.add(candidates[i]);
            dps(candidates, i, list, target, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
    }

}
