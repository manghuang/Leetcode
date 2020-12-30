package leetcode14;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class Solution12 {


    // 快排
    public int[] sort(int[] nums){
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left >= right){
            return;
        }
        int target = nums[left];
        int a = left;
        int b = right;
        while (a < b){
            while (a < b && nums[b] > target){
                b--;
            }
            if(a < b){
                nums[a] = nums[b];
            }
            while (a < b && nums[a] <= target){
                a++;
            }
            if(a < b){
                nums[b] = nums[a];
            }
        }
        nums[a] = target;
        quickSort(nums, left, a-1);
        quickSort(nums, a+1, right);
    }

    public static void main(String[] args) {
        // 因为字符串的equals方法机制是不同类型的直接返回false
//        String a = "1";
//        int b  = 1;
//        System.out.println(a.equals(b));

//        int[] res = new Solution12().sort(new int[]{4, 3, 2, 1, 5});
//        System.out.println(Arrays.toString(res));

//        // 8.缓存池
//        Integer a = 1;
//        Integer b = 1;
//        System.out.println(a == b); // true;
//        Integer c = 200;
//        Integer d = 200;
//        System.out.println(c == d); // false

    }
}
