package leetcode6;

import java.util.LinkedList;

public class Solution5 {

    /*
        并查集：查找和合并
        dps
        bps
     */

//    private  int[] father;
//    public boolean isBipartite(int[][] graph) {
//        int length = graph.length;
//        this.father = new int[2*length];
//        for (int i = 0; i <father.length ; i++) {
//            father[i] = i;
//        }
//        for (int i = 0; i <length ; i++) {
//            for (int j = 0; j <graph[i].length ; j++) {
//                // 和自己一起的
//                int x = find(i);
//                int y = find(graph[i][j]);
//                // +n 和自己分开的
//                int a = find(i + length);
//                int b = find(graph[i][j] + length);
//                if(x == y){
//                    return false;
//                } else{
//                    father[a] = y;
//                    father[b] = x;
//                }
//            }
//        }
//        return true;
//    }
//
//    private int find(int x) {
//        if(x != father[x]){
//            father[x] = find(father[x]);
//        }
//        return father[x];
//    }

//    private int[] color;
//    public boolean isBipartite(int[][] graph) {
//        int length = graph.length;
//        this.color = new int[length];
//        for (int i = 0; i <length ; i++) {
//            if(color[i] == 0){
//                if(!dps(graph, i, 1)){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    private boolean dps(int[][] graph, int thisNode, int thisColor) {
//        this.color[thisNode] = thisColor;
//        int nextColor = thisColor == 1? 2:1;
//        for (int nextNode:
//             graph[thisNode]) {
//            int value = this.color[nextNode];
//            if(value == 0){
//                if(!dps(graph, nextNode, nextColor)){
//                    return false;
//                }
//            }else if(value == thisColor) {
//                return false;
//            }
//        }
//        return true;
//    }

    private int[] color;

    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        this.color = new int[length];
        for (int i = 0; i < length; i++) {
            if (this.color[i] == 0) {
                if (!bps(i, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bps(int thisNode, int[][] graph) {
        this.color[thisNode] = 1;
        LinkedList<Integer> list = new LinkedList<>();
        list.offer(thisNode);
        while (!list.isEmpty()) {
            Integer temp = list.remove();
            int thisColor = this.color[temp];
            int nextColor = thisColor == 1 ? 2 : 1;
            for (int nextNode :
                    graph[temp]) {
                if (this.color[nextNode] == 0) {
                    this.color[nextNode] = nextColor;
                    list.offer(nextNode);
                } else if (this.color[nextNode] == thisColor) {
                    return false;
                }
            }
        }
        return true;
    }

}
