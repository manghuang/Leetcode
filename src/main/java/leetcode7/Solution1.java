package leetcode7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
    /*
        依赖问题
     */
    private HashMap<Integer, Node> hashMap;

    public Node cloneGraph(Node node) {
        if (node == null) {
            return new Node();
        }
        hashMap = new HashMap<>();
        Node newNode = new Node(node.val);
        hashMap.put(node.val, newNode);
        dps(newNode, node);
        return newNode;
    }

    private void dps(Node newNode, Node node) {
        List<Node> neighbors = node.neighbors;
        if (neighbors == null) {
            return;
        }
        for (Node neightbor :
                neighbors) {
            if (hashMap.containsKey(neightbor.val)) {
                newNode.neighbors.add(hashMap.get(neightbor.val));
            } else {
                Node newNeightbor = new Node(neightbor.val);
                hashMap.put(neightbor.val, newNeightbor);
                newNode.neighbors.add(newNeightbor);
                dps(newNeightbor, neightbor);
            }
        }
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

