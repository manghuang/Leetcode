package leetcode15;

public class Solution5 {

    // 在树的基础上添加一条，所以一定存在，且只存在一条
    // 使用并查集
    public int[] findRedundantConnection(int[][] edges) {
        int lineNum = edges.length;
        UnionFInd unionFInd = new UnionFInd(lineNum);
        for (int[] edge : edges) {
            int point1 = edge[0] - 1;
            int point2 = edge[1] - 1;
            if (unionFInd.find(point1) != unionFInd.find(point2)) {
                unionFInd.unoin(point1, point2);
            } else {
                return edge;
            }
        }
        return new int[2];
    }

    private static class UnionFInd{
        private final int[] parent;

        public UnionFInd(int num){
            parent = new int[num];
            for (int i = 0; i <num ; i++) {
                parent[i] = i;
            }
        }

        public int find(int index){
            if(parent[index] != index){
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }

        public void unoin(int index1, int index2){
            int parent1 = find(index1);
            int parent2 = find(index2);
            if(parent1 != parent2){
                parent[parent1] = parent2;
            }
        }
    }
}
