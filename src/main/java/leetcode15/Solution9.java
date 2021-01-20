package leetcode15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution9 {

    // 完整排序 nlgn
    // 堆排序 nlgk  这个复杂度更低
    // 线性查找 kn
    public int maximumProduct(int[] nums) {
        int length = nums.length;
        PriorityQueue<Integer> maxThreeNums = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        PriorityQueue<Integer> minThreeNums = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < length; i++) {
            if(maxThreeNums.size() == 3){
                if(nums[i] > maxThreeNums.peek()){
                    maxThreeNums.poll();
                    maxThreeNums.add(nums[i]);
                }
            }else {
                maxThreeNums.add(nums[i]);
            }

            if(minThreeNums.size() == 2){
                if(nums[i] < minThreeNums.peek()){
                    minThreeNums.poll();
                    minThreeNums.add(nums[i]);
                }
            }else {
                minThreeNums.add(nums[i]);
            }
        }
        int[] temp = new int[5];
        temp[1] = minThreeNums.poll();
        temp[0] = minThreeNums.poll();
        temp[2] = maxThreeNums.poll();
        temp[3] = maxThreeNums.poll();
        temp[4] = maxThreeNums.poll();
        int num1 = temp[0]*temp[1]*temp[4];
        int num2 = temp[2]*temp[3]*temp[4];
        return Math.max(num1, num2);
    }
}
