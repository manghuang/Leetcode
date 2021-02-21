package newyear.leetcode0;

import java.util.Deque;
import java.util.LinkedList;

public class Solution4 {


    // 使用双向队列，遍历过程中当作栈使用，当不满足条件时候弹出队列头部的node
    public int longestSubarray(int[] nums, int limit) {
        if(nums == null || nums.length == 0 || limit < 0){
            return 0;
        }
        int length = nums.length;
        int left = -1;
        int right = 0;
        int ans = 0;
        Deque<Integer> minStack = new LinkedList<>();
        Deque<Integer> maxStack = new LinkedList<>();
        while (right < length) {

            /*
                             last ... first
                  作为栈：
                                            -> pop
                                            <- push
                 作为队列：
                            ->offer         ->poll
             */
            // last为left到right窗口内的最小值对应的下标，上升
            while (!minStack.isEmpty() && nums[right] < nums[minStack.peek()]){
                minStack.pop();
            }
            minStack.push(right);

            // last为left到right窗口内的最大值对应的下标，上升
            while (!maxStack.isEmpty() && nums[right] > nums[maxStack.peek()]){
                maxStack.pop();
            }
            maxStack.push(right);

            // 调整left满足条件
            while ((nums[maxStack.getLast()] - nums[minStack.getLast()]) > limit){
                if(maxStack.getLast() <= minStack.getLast()){
                    left = maxStack.removeLast();
                }else {
                    left = minStack.removeLast();
                }
            }
            ans = Math.max(ans, right - left);
            right++;
        }
        return  ans;
    }
}
