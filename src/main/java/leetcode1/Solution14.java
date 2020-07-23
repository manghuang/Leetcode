package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Solution14 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        List<List<Integer>> b = new Solution14().permute(a);
        for (List<Integer> list : b) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result);

        return result;
    }

    private void dfs(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            List<Integer> temp = new ArrayList<>();
            for (int i : nums) {
                temp.add(i);
            }
            result.add(temp);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            dfs(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int start, int i) {
        int a = nums[start];
        nums[start] = nums[i];
        nums[i] = a;
    }
}
