package leetcode14;

import java.util.*;

public class Solution8 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return  new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean fromLeftToRight = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(fromLeftToRight){
                fromLeftToRight = false;
                res.add(list);
            }else {
                fromLeftToRight = true;
                Collections.reverse(list);
                res.add(list);
            }
        }
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
