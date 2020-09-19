package leetcode9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution4 {

    /*
        0/1背包问题,完全背包问题
            1.组合排序
            2.是否有
            3.最大最小问题
        如果要求具体解,则需要dps+回溯
        如果求个数,则可以dps+状态数组/动态规划

        数组的硕自是不是重复,可不可以重复使用
        可以取的个数是不是由限制
     */
    private int res;

    public static void main(String[] args) {
        int res = new Solution4().combinationSum4(new int[]{5, 1, 8}, 24);
        System.out.println(res);
    }

    // 超时问题
//    private void dps(int[] nums, int target, int sum) {
//        if(sum == target){
//            res++;
//            return;
//        }
//        for (int num : nums) {
//            int temp = sum + num;
//            if (temp > target) {
//                break;
//            } else {
//                dps(nums, target, sum + num);
//            }
//        }
//    }

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0) {
            return 0;
        }
        Arrays.sort(nums);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        dps(nums, target, nums.length - 1, 0, hashMap);
//        dps(nums, target, 0);
        return res;
    }

    // 数太大放不下问题
    private void dps(int[] nums, int target, int index, int sum, HashMap<Integer, Integer> hashMap) {
        if (sum == target) {
            int size = 0;
            long temp = 1;
            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()
            ) {
                int a = entry.getValue();
                if (a != 0) {
                    size += a;
                    temp *= jianC(a);
                }

            }
            System.out.println(jianC(size) + "   " + temp + "   " + jianC(size) / temp);
            res += jianC(size) / temp;
            System.out.println(res);

            return;
        }
        if (index < 0 || sum > target) {
            return;
        }

        for (int i = index; i >= 0; i--) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
            dps(nums, target, i, sum + nums[i], hashMap);
            hashMap.put(nums[i], hashMap.get(nums[i]) - 1);
        }
    }

    private long jianC(int value) {
        long res = 1;
        for (int i = 2; i <= value; i++) {
            res *= i;
        }
        return res;
    }
}
