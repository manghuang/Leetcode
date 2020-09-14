package leetcode8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution10 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bps(root, res);
        return res;
    }

    /*
        堆栈
     */
    private void bps(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
//        linkedList.push(root);
//        boolean down = true;
//        while (!linkedList.isEmpty()){
//            TreeNode temp = linkedList.peek();
//            if(down && temp.left != null){
//                linkedList.push(temp.left);
//            }else {
//                res.add(temp.val);
//                linkedList.pop();
//                down = false;
//                if(temp.right != null){
//                    linkedList.push(temp.right);
//                    down = true;
//                }
//            }
//        }
        while (root != null || !linkedList.isEmpty()) {
            while (root != null) {
                linkedList.push(root);
                root = root.left;
            }
            root = linkedList.pop();
            res.add(root.val);
            root = root.right;
        }
    }

    //    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        dps(root, res);
//        return res;
//    }
//    private void dps(TreeNode root, List<Integer> res){
//        if(root == null){
//            return;
//        }
//        dps(root.left, res);
//        res.add(root.val);
//        dps(root.right, res);
//    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
