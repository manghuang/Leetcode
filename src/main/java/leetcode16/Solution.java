package leetcode16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public List<Integer> getTopK(int[] nums, int k){

        if(nums == null || k < 0 || nums.length < k){
            return new ArrayList<>();
        }

        int length = nums.length;
        // 最小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0; i < length; i++) {
            if(priorityQueue.size() >= k){
                if(priorityQueue.peek() < nums[i]){
                    priorityQueue.poll();
                    priorityQueue.add(nums[i]);
                }else {
                    continue;
                }
            }else {
                priorityQueue.add(nums[i]);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            list.add(priorityQueue.poll());
        }
        return list;
    }
}
