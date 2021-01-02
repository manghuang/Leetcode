package leetcode15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {


//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int length = nums.length;
//        if(k == 1){
//            return Arrays.copyOf(nums, length);
//        }
//        int[] ans = new int[length-k+1];
//        int maxIndex = -1;
//        for (int i = 0; i < ans.length; i++) {
//            if(i > maxIndex){
//                int temp = i;
//                for (int j = i+1; j <i+k ; j++) {
//                    if(nums[j] >= nums[temp]){
//                        temp = j;
//                    }
//                }
//                maxIndex = temp;
//                ans[i] = nums[maxIndex];
//            }else {
//                if(nums[i+k-1] >= nums[maxIndex]){
//                    ans[i] = nums[i+k-1];
//                    maxIndex = i+k-1;
//                }else {
//                    ans[i] = nums[maxIndex];
//                }
//            }
//        }
//        return ans;
//    }

        public int[] maxSlidingWindow(int[] nums, int k) {
            int length = nums.length;
            if(k == 1){
                return Arrays.copyOf(nums, length);
            }
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1] == o2[1]){
                        return o2[0] - o1[0];
                    }else {
                        return o2[1] - o1[1];
                    }
                }
            });
            for (int i = 0; i < k-1; i++) {
                priorityQueue.offer(new int[]{i, nums[i]});
            }
            int[] ans = new int[length-k+1];
            for (int i = 0; i <ans.length  ; i++) {
                int lastIndex = i+k-1;
                priorityQueue.offer(new int[]{lastIndex, nums[lastIndex]});
                while (true){
                    assert priorityQueue.peek() != null;
                    if (!(priorityQueue.peek()[0] < i)) break;
                    priorityQueue.poll();
                }
                ans[i] = priorityQueue.peek()[1];
            }
            return ans;
        }
}
