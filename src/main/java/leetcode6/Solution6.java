package leetcode6;

public class Solution6 {

//        public int numSub(String s) {
//            ArrayList<Integer> list = new ArrayList<>();
//            int length = s.length();
//            int index = 0;
//            boolean bOne = false;
//            for(int i=0; i<length; i++){
//                if(s.charAt(i) == '1'){
//                    if(bOne){
//                        index ++;
//                    }else{
//                        bOne = true;
//                        index = 1;
//                    }
//                }else{
//                    if(bOne){
//                        bOne = false;
//                        list.add(index);
//                        index = 0;
//                    }
//                }
//            }
//            if(bOne){
//                list.add(index);
//            }
//            int res = 0;
//            int a = (int)Math.pow(10, 9) + 7;
//            for(int num: list){
//                res += (num + 1) * num/2;
//                res = res % a;
//            }
//            return res;
//        }

    private boolean[] isVisted;
    private double[] distance;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ListNode[] graph = new ListNode[n];

        for (int i = 0; i < edges.length; i++) {
            int left = edges[i][0];
            int right = edges[i][1];
            ListNode leftNode = new ListNode(right, succProb[i]);
            leftNode.nextNode = graph[left];
            graph[left] = leftNode;
            ListNode rightNode = new ListNode(left, succProb[i]);
            rightNode.nextNode = graph[right];
            graph[right] = leftNode;

        }
        this.isVisted = new boolean[n];
        this.distance = new double[n];
        bps(graph, start, end);
        if (isVisted[end]) {
            return distance[end];
        } else {
            return 0;
        }
    }

    private void bps(ListNode[] graph, int start, int end) {
        int length = graph.length;
        distance[start] = 1;
        while (true) {
            int next = -1;
            double maxdis = 0;
            for (int i = 0; i < length; i++) {
                if (!isVisted[i] && distance[i] > maxdis) {
                    next = i;
                    maxdis = distance[i];
                }
            }
            if (next == -1) {
                return;
            }
            isVisted[next] = true;
            if (next == end) {
                return;
            }
//            for (int i = 0; i < length ; i++) {
//                if(!isVisted[i] && graph[next][i] != -1){
//                    if(distance[i] <  distance[next] * graph[next][i]){
//                        distance[i] = distance[next] * graph[next][i];
//                    }
//                }
//            }
            ListNode node = graph[next];
            while (node != null) {
                int nodeNum = node.nodeNum;
                double engeValue = node.edgeValue;
                if (!isVisted[nodeNum]) {
                    distance[nodeNum] = Math.max(distance[nodeNum], distance[next] * engeValue);
                }
                node = node.nextNode;
            }
        }
    }

    private class ListNode {
        int nodeNum;
        double edgeValue;
        ListNode nextNode;

        public ListNode(int nodeNum, double edgeValue) {
            this.nodeNum = nodeNum;
            this.edgeValue = edgeValue;
        }

    }

}
