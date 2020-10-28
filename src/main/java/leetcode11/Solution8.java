package leetcode11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution8 {

//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//
//        list.add(root.val);
//        List<Integer> left = preorderTraversal(root.left);
//        List<Integer> right = preorderTraversal(root.right);
//        if (left.size() != 0) {
//            list.addAll(left);
//        }
//        if (right.size() != 0) {
//            list.addAll(right);
//        }
//        return list;
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            if(treeNode.right != null){
                stack.push(treeNode.right);
            }
            if(treeNode.left != null){
                stack.push(treeNode.left);
            }

        }
        return res;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
