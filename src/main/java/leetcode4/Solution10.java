package leetcode4;

import java.util.Arrays;

public class Solution10 {

    /*
        方式一、枚举，三重循环
        方式二、排序+使用二叉查找优化(定两个，找一个)
               Arrays.binarySearch()返回值分类讨论:
                 [1] 该搜索键在范围内，但不是数组元素，由1开始计数，得“ - 插入点索引值”；
                 [2] 该搜索键在范围内，且是数组元素，由0开始计数，得搜索值的索引值；
                 [3] 该搜索键不在范围内，且小于范围（数组）内元素，返回–(fromIndex + 1)；
                 [4] 该搜索键不在范围内，且大于范围（数组）内元素，返回 –(toIndex + 1)。

        方式三、排序+双指针(定一个，找两个，左右指针)
     */
//    public int threeSumClosest(int[] nums, int target) {
//        int res = nums[0] + nums[1] + nums[2];
//        for (int i = 0; i < nums.length-2 ; i++) {
//            for (int j = i+1; j <nums.length-1 ; j++) {
//                for (int k = j+1; k < nums.length ; k++) {
//                    int temp = nums[i] + nums[j] + nums[k];
//                    if(Math.abs(temp - target) < Math.abs(res-target)){
//                        res = temp;
//                    }
//                }
//            }
//        }
//        return res;
//    }

//    public int threeSumClosest(int[] nums, int target) {
//        Arrays.sort(nums);
//        int res = nums[0] + nums[1] + nums[2];
//        for (int i = 0; i < nums.length-2 ; i++) {
//            if(i != 0 && nums[i] == nums[i-1]){
//                continue;
//            }
//            for (int j = i+1; j <nums.length-1 ; j++) {
//                if(j != (i+1) && nums[j] == nums[j-1]){
//                    continue;
//                }
//                int temp = target - nums[i] - nums[j] ;
//
//                int a = Arrays.binarySearch(nums, j+1, nums.length, temp);
//                if(a == -(j+2)){
//                    a = j+1;
//                }else if(a == -(nums.length+1)){
//                    a = nums.length-1;
//                }else if(a < 0){
//                    a = -a-1;
//                    if(Math.abs(temp-nums[a]) > Math.abs(temp - nums[a-1])){
//                        a = a-1;
//                    }
//                }else {
//                    return target;
//                }
//
//                if(Math.abs(temp - nums[a]) < Math.abs(res - target)){
//                    res = nums[i] + nums[j] + nums[a];
//                }
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 1, 55};
        int target = 3;
        int res = new Solution10().threeSumClosest(nums, target);
        System.out.println(res);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int temp = target - nums[i];
            while (left < right) {
                int sum = nums[left] + nums[right];

                if (Math.abs(temp - sum) < Math.abs(res - target)) {
                    res = sum + nums[i];
                }

                if (sum < temp) {
                    left++;
                } else if (sum == temp) {
                    return target;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

}
