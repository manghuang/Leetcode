package leetcode8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution3 {

    /*
        方式一：排序算法，HashMap的按键排序，按值排序
        方式二：小顶堆，HashMap的遍历，PriorityQueue的使用，堆，排序

     */
//    public int[] topKFrequent(int[] nums, int k) {
//        if(nums == null || nums.length == 0){
//            return new int[0];
//        }
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int num: nums
//             ) {
//            if(hashMap.containsKey(num)){
//                hashMap.put(num, hashMap.get(num) +1);
//            }else {
//                hashMap.put(num, 1);
//            }
//        }
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
//        // 降序排列
//        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
//        int[] res = new int[k];
//        for (int i = 0; i <k ; i++) {
//            res[i] = list.get(i).getKey();
//        }
//        return res;
//    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }


}
