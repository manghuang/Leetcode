package leetcode1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution18 {

    //bfs如何区分层
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            LinkedList<TreeNode> ll = new LinkedList<>();
            ll.offer(root);
            while (!ll.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int length = ll.size();
                for (int i = 0; i < length; i++) {
                    TreeNode temp = ll.remove();
                    list.add(temp.val);
                    if (temp.left != null) {
                        ll.offer(temp.left);
                    }
                    if (temp.right != null) {
                        ll.offer(temp.right);
                    }
                }
                result.add(list);
            }
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
