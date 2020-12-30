package leetcode14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution11 {

    public int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length == 0){
            return 0;
        }
        int length = stones.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int stone : stones) {
            priorityQueue.add(stone);
        }
        while (priorityQueue.size() > 1){
            int y = priorityQueue.poll();
            int x = priorityQueue.poll();
            if(y == x){
                continue;
            }else {
                priorityQueue.add(y-x);
            }
        }

        if(priorityQueue.isEmpty()){
            return 0;
        }else {
            return priorityQueue.poll();
        }
    }
}
