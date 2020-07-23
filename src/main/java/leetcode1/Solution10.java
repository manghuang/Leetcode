package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Solution10 {


    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        List<ArrayList<TreeNode>> list = new ArrayList<>();
        ArrayList<TreeNode> al1 = new ArrayList<>();
        al1.add(root);
        list.add(al1);
        boolean isok = true;
        int index = 0;
        while (isok) {
            isok = false;
            ArrayList<TreeNode> temp1 = list.get(index++);
            ArrayList<TreeNode> temp2 = new ArrayList<>();
            for (TreeNode tn : temp1) {
                if (tn.right != null) {
                    isok = true;
                    temp2.add(tn.right);
                }
                if (tn.left != null) {
                    isok = true;
                    temp2.add(tn.left);
                }
            }
            if (isok) {
                list.add(temp2);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (ArrayList<TreeNode> al2 : list) {
            result.add(al2.get(0).val);
        }

        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
