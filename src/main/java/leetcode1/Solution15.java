package leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public static void reverse(int nums[], int i) {
        int k = i, j = nums.length - 1;
        while (k < j) {
            swap(nums, k, j);
            k++;
            j--;
        }
    }

    public static void swap(int nums[], int i, int j) {
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        List<List<Integer>> b = new Solution15().permute(a);
        for (List<Integer> list : b) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();

        PermutationWithDictionary(nums, result);
        return result;
    }

    private void PermutationWithDictionary(int[] nums, List<List<Integer>> result) {
        Arrays.sort(nums);
        //先对数组的元素进行依次排序
        while (true) {

            List<Integer> temp = new ArrayList<>();
            for (int i : nums) {
                temp.add(i);
            }
            result.add(temp);
            int j;
            int index = 0;
            for (j = nums.length - 2; j >= 0; j--) {
                if (nums[j] < nums[j + 1]) {
                    index = j;
                    break;
                    //从右向左找到第一个非递增的元素
                } else if (j == 0) {
                    return;
                }
            }

            for (j = nums.length - 1; j >= 0; j--) {
                if (nums[j] > nums[index])
                    break;
                //从右向左找到第一个比非递增元素大的元素
            }
            if (j == -1) {
                break;
            }
            swap(nums, index, j);
            //交换找到的两个元素
            reverse(nums, index + 1);
            //对非递增元素位置后面的数组进行逆序排列
        }
    }
}
