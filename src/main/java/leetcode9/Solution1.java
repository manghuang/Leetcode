package leetcode9;


public class Solution1 {

    /*
        dps,交换每一个非叶子节点的左右节点
        bps也可以
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode treeNode = root.left;
        root.left = root.right;
        root.right = treeNode;
        return root;
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
