package leetcode9;

import java.util.Arrays;

public class Solution2 {

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {1, 3}, {2, 3}};
        int[] res = new Solution2().findRedundantDirectedConnection(nums);
        System.out.println(Arrays.toString(res));
    }

//    private Map<Integer, Integer> findCircle(boolean[][] map) {
//        Map<Integer, Integer> hashMap = new HashMap<>();
//        LinkedList<Integer> stack = new LinkedList<>();
//        for (int i = 0; i < map.length ; i++) {
//            if(dfs(map, stack, i)){
//                break;
//            }
//        }
//        System.out.println(stack);
//        int top = stack.pop();
//        int last = stack.pop();
//        hashMap.put(top, last);
//        while (last != top){
//           hashMap.put(last, stack.peek());
//           last = stack.pop();
//        }
//        return hashMap;
//    }
//
//    private boolean dfs(boolean[][] map, LinkedList<Integer> stack, int index) {
//        if(stack.contains(index)){
//            stack.push(index);
//            return true;
//        }
//        stack.push(index);
//        for (int i = 0; i < map.length; i++) {
//            if(map[index][i]){
//                if(dfs(map, stack, i)){
//                    return true;
//                }
//            }
//        }
//        stack.pop();
//        return false;
//    }

    /*
        有向图，由一个树+附加边组成，说明一定有解
                统计所有节点的入度
                如果存在一个入度为2的节点,同时必有一个入度为0的节点，可能有环，可能无环
                如果均是入度为1的节点，必有环




     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inNums = new int[n];
        int[][] map = new int[n][n];
        int node = -1;
        for (int i = 0; i < n; i++) {
            inNums[edges[i][1] - 1]++;
            map[edges[i][0] - 1][edges[i][1] - 1] = i + 1;
        }
        for (int i = 0; i < n; i++) {
            if (inNums[i] == 2) {
                node = i;
            }
        }
        if (node != -1) {
            int a, b;
            for (int i = 0; i < n; i++) {
                if (map[i][node] != 0) {

                }
            }
        } else {

        }
        return new int[2];
    }
}
