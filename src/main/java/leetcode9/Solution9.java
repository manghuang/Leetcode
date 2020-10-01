package leetcode9;

public class Solution9 {


    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        bps(root);
        return root;
    }

    private void bps(Node root) {
        if (root == null) {
            return;
        }
        Node firstNode = root;
        while (firstNode != null) {
            Node node = firstNode;
            firstNode = null;

        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

        /*
            先遍历再建立指针，空间复杂度为O(n)
            先建立指针再遍历，空间复杂度为O(1)
         */
//        private void bps(Node root) {
//            if(root == null){
//                return;
//            }
//            LinkedList<Node> queue = new LinkedList<>();
//            queue.offer(root);
//            while(!queue.isEmpty()){
//                int size = queue.size();
//                for (int i = 0; i < size ; i++) {
//                    Node node = queue.remove();
//                    if(i != size-1){
//                        node.next = queue.peek();
//                    }
//                    if(node.left != null){
//                        queue.offer(node.left);
//                    }
//                    if(node.right != null){
//                        queue.offer(node.right);
//                    }
//                }
//            }
//        }

}
