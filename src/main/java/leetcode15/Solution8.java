package leetcode15;

import java.util.*;

public class Solution8 {

    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        if(length == 1){
            return 0;
        }
        // 最小生成树
        // 两点之间一条路径，总共n(n-1)/2条路径
        List<TwoPointCost> edges = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                TwoPointCost twoPointCost = new TwoPointCost(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                edges.add(twoPointCost);
            }
        }
        edges.sort(new Comparator<TwoPointCost>() {
            @Override
            public int compare(TwoPointCost o1, TwoPointCost o2) {
                return o1.cost - o2.cost;
            }
        });
        int ans = 0;
        UnionFind unionFind = new UnionFind(length);

        for (TwoPointCost twoPointCost : edges) {
            if(unionFind.find(twoPointCost.point1Inxex) != unionFind.find(twoPointCost.point2Index)){
                unionFind.union(twoPointCost.point1Inxex, twoPointCost.point2Index);
                ans += twoPointCost.cost;
            }
        }

        return ans;
    }

    private static class TwoPointCost{
        int point1Inxex;
        int point2Index;
        int cost;

        public TwoPointCost(int point1Inxex, int point2Index, int cost) {
            this.point1Inxex = point1Inxex;
            this.point2Index = point2Index;
            this.cost = cost;
        }
    }

    private static class UnionFind{
        private final int[] parent;

        public UnionFind(int num){
            parent = new int[num];
            for (int i = 0; i < num; i++) {
                parent[i] = i;
            }
        }

        public int find(int index){
            if(parent[index] != index){
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }

        public void union(int index1, int index2){
            int index1Par = find(index1);
            int index2Par = find(index2);
            if(index1Par != index2Par){
                parent[index1Par] = index2Par;
            }
        }

    }

}
