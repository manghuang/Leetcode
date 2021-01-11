package leetcode15;

import java.util.*;

public class Solution4 {


    // 并查集或者转换未矩阵数组，遍历求集合
    // 并查集的两个操作，查询和合并
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(s == null || s.length() == 0){
            return s;
        }
        int length = s.length();
        UnionFind unionFind = new UnionFind(length);

        for (List<Integer> list : pairs) {
            int fatherId1 = unionFind.find(list.get(0));
            int fatherId2 = unionFind.find(list.get(1));
            unionFind.union(fatherId1, fatherId2);
        }
        char[] c = s.toCharArray(); // 优化
        // fatherIndex, childIndex
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();  //优化
        for (int i = 0; i < length; i++) {
            int fatherIndex = unionFind.find(i);
            if(map.containsKey(fatherIndex)){
                map.get(fatherIndex).add(c[i]);
            }else {
                PriorityQueue<Character> priorityQueue = new PriorityQueue<>();
                priorityQueue.add(c[i]);
                map.put(fatherIndex, priorityQueue);
            }
        }
        char[] chs = new char[length];
        for (int i = 0; i < length; i++) {
            int fatherId = unionFind.find(i);
            chs[i] = map.get(fatherId).poll();
        }
        return String.valueOf(chs);
    }

    private static class UnionFind{
        private int[] parent;

        public UnionFind(int length){
            parent = new int[length];
            for (int i = 0; i < length; i++) {
                parent[i] = i;
            }
        }

        // 需要优化
        public int find(int index){
            if(index != parent[index]){
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }

        // 需要优化
        private void union(int index1, int index2){
            int fartherId1 = find(index1);
            int fartherId2 = find(index2);
            if(fartherId1 == fartherId2){
                return;
            }
            parent[fartherId1] = fartherId2;
//            for (int i = 0; i < fartherIds.length; i++) {
//                if(parent[i] == fartherId1){
//                    parent[i] = fartherId2;
//                }
//            }
        }
    }

}
