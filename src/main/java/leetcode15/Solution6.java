package leetcode15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution6 {

    // 并查集，但不是两点之间的连通，而是行或者列之间的连通
    // 二维数组可以直接区分行和列，但是并查集是一维数组，如何区分
    // 这个并查集连通的是行和列
    public int removeStones(int[][] stones) {
        int length = stones.length;
        UnionFind unionFind = new UnionFind(length);
        for (int[] stone : stones) {
            unionFind.union(~stone[0], stone[1]);
        }
        return length - unionFind.getCount();
    }

    private  static class UnionFind{
        private final Map<Integer, Integer> parent;

        private int count;

        public UnionFind(int num){
            parent = new HashMap<>();
            count = 0;
        }

        public int getCount(){
            return count;
        }
        public int find(int index){
            if(!parent.containsKey(index)){
                parent.put(index, index);
                count++;
            }
            if(parent.get(index) != index){
                parent.put(index, find(parent.get(index)));
            }
            return parent.get(index);
        }

        public void union(int index1, int index2){
            int index1Par = find(index1);
            int index2Par = find(index2);

            if(index1Par != index2Par){
                parent.put(index1Par, index2Par);
                count--;
            }
        }
    }
}
