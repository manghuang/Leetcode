package leetcode8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution6 {

    /*
        一个数组，里面的数字不可以重复，可以重复使用，选择其中的数组成target,个数不限（已经解决）
        一个数组，里面的数字可以重复，不可以重复使用，选择其中的数组成target,个数为两个或者三个（已经解决）

        一个数组，里面的数字可以重复，不可以重复使用，选择其中的数组成target,个数不限制（本题）

        一个数组，里面的数字不可以重复，可以重复使用，选择其中的数组成target,个数有限（未遇到）
     */
    /*
        数字需要排序：升序和降序的区别？ 升序有影响吗？升序会有很多无意义的比较，需要的时间上升！！！！
     */
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
//        dps(candidates, target, list, 0, candidates.length-1);
        dps(candidates, target, list, 0, 0);
        return res;
    }

//    private void dps(int[] candidates, int target, List<Integer> list, int sum, int index) {
//        if(sum == target){
//            List<Integer> temp = new ArrayList<>(list);
//            this.res.add(temp);
//            return;
//        }
//        if(sum > target || index < 0){
//            return;
//        }
//        int lastNum = -1;
//        for (int i = index; i >= 0 ; i--) {
//            if(candidates[i] == lastNum){
//                continue;
//            }
//            lastNum = candidates[i];
//            list.add(candidates[i]);
//            dps(candidates, target, list, sum+candidates[i], i-1);
//            list.remove((list.size()-1));
//        }
//    }

    private void dps(int[] candidates, int target, List<Integer> list, int sum, int index) {
        if (sum == target) {
            List<Integer> temp = new ArrayList<>(list);
            this.res.add(temp);
            return;
        }
        if (sum > target || index < 0) {
            return;
        }
        int lastNum = -1;
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] == lastNum) {
                continue;
            }
            lastNum = candidates[i];
            list.add(candidates[i]);
            dps(candidates, target, list, sum + candidates[i], i + 1);
            list.remove((list.size() - 1));
        }
    }
}
