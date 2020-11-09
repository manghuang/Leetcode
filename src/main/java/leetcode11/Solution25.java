package leetcode11;

import java.util.*;

public class Solution25 {


    /*
        全排序：hashMap
        部分排序：最小堆来实现,优先队列
     */
    public int[][] kClosest(int[][] points, int K) {
        int length = points.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i <length ; i++) {
            int temp = (int)(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            hashMap.put(i, temp);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        int[][] res = new int[K][];
        for (int i = 0; i <K ; i++) {
            res[i] = points[list.get(i).getKey()];
        }
        return res;
    }
}
