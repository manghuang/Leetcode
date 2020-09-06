package leetcode8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {

    private final List<List<Integer>> res = new ArrayList<>();

      /*
            层序遍历：bps
            dps
       */
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//
//        if(root == null){
//            return new ArrayList<>();
//        }
//        List<List<Integer>> res = bps(root);
//        Collections.reverse(res);
//        return res;
//    }

//    private List<List<Integer>> bps(TreeNode root) {
//        if(root == null){
//            return new ArrayList<>();
//        }
//        List<List<Integer>> res = new ArrayList<>();
//        LinkedList<TreeNode> queue= new LinkedList<>();
//        queue.offer(root);
//        //每一次遍历一层
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i <size ; i++) {
//                TreeNode temp = queue.remove();
//                list.add(temp.val);
//                if(temp.left != null){
//                    queue.add(temp.left);
//                }
//                if(temp.right != null){
//                    queue.offer(temp.right);
//                }
//            }
//            res.add(list);
//        }
//        return res;
//    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) {
            return this.res;
        }
        dps(root, 1);
        Collections.reverse(this.res);
        return this.res;
    }

    private void dps(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        if (num > this.res.size()) {
            this.res.add(new ArrayList<>());
        }
        this.res.get(num - 1).add(root.val);
        dps(root.left, num + 1);
        dps(root.right, num + 1);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
