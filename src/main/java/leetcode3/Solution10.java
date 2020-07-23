package leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution10 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> lists = new Solution10().threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    //    方式一、暴力枚举，找出满足条件的，去重
    /*
      方式二、在方式一的基础上优化，通过排序，针对重复数字的规则，来避免去重的操作
      枚举过程中有三层循环嵌套，针对不同层次的规则是：
            第一层：下一个数字一定和上一个不同
            第二层：下一个数字一定和上一个不同
            第三层：下一个数字一定和上一个不同
     */
//    方式三、盲猜动态规划？万物可动态规划？狗头
//    public List<List<Integer>> threeSum(int[] nums) {
//
//        List<List<Integer>> res = new ArrayList<>();
//        if(nums == null || nums.length == 0){
//            return res;
//        }
//        Arrays.sort(nums);
//        Map<Integer, Integer> map = new HashMap();
//        for (int num: nums) {
//            map.put(num, map.getOrDefault(num,0)+1);
//        }
//        int length = nums.length;
//        for(int i=0; i<length; i++){
//            if(i !=0 && nums[i] == nums[i-1]){
//                continue;
//            }
//            if(nums[i] > 0){
//                break;
//            }
//            for(int j=i+1; j<length; j++){
//                if(j !=i+1 && nums[j] == nums[j-1]){
//                    continue;
//                }
//                int temp = -nums[i] - nums[j];
//                if(temp < nums[j]){
//                    continue;
//                }
//                int a = 0;
//                if(temp == nums[i]){
//                    a++;
//                }
//                if(temp == nums[j]){
//                    a++;
//                }
//                if(map.containsKey(temp) && map.get(temp) >a){
//                    List<Integer> list = new ArrayList<>();
//                    list.add(nums[i]);
//                    list.add(nums[j]);
//                    list.add(temp);
//                    res.add(list);
//                }
//            }
//        }
//        return res;
//    }
    /*
      好像不能用动态规划，而是要用前缀和，但是用前缀和，也需要两层循环嵌套
      用双指针，枚举一层,后两层用指针
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || nums.length == 1 || nums.length == 2) {
            return res;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int head = i + 1;
            int tail = length - 1;
            int target = -nums[i];
            while (head < tail) {
                int temp = nums[head] + nums[tail];
                if (temp == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[head]);
                    list.add(nums[tail]);
                    res.add(list);
                    head++;
                    while (head < tail && nums[head] == nums[head - 1]) {
                        head++;
                    }
                    tail--;
                    while (head < tail && nums[tail] == nums[tail + 1]) {
                        tail--;
                    }
                } else if (temp < target) {
                    head++;
//                    while (head < tail && nums[head] == nums[head-1]){
//                        head++;
//                    }
                } else {
                    tail--;
//                    while (head < tail && nums[tail] == nums[tail+1]){
//                        tail--;
//                    }
                }
            }
        }
        return res;
    }
}
