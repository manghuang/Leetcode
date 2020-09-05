package leetcode8;

import java.util.ArrayList;
import java.util.List;

public class Solution0 {

    /*
        dps+return
     */
    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        return dps(root);
    }

    private List<String> dps(TreeNode root) {
        if (root == null) {
            return null;
        }
        int val = root.val;
        List<String> leftRes = dps(root.left);
        List<String> rightRes = dps(root.right);
        List<String> res = new ArrayList<>();
        if (leftRes == null && rightRes == null) {
            res.add(String.valueOf(val));
        }
        if (leftRes != null) {
            for (String str : leftRes
            ) {
                res.add(String.valueOf(val) + "->" + str);
            }
        }
        if (rightRes != null) {
            for (String str : rightRes
            ) {
                res.add(String.valueOf(val) + "->" + str);
            }
        }

        return res;
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
