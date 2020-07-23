package leetcode2;

public class Solution5 {

    //层序遍历
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        int length = preorder.length;
        return buildTree(preorder, inorder, 0, length - 1, 0, length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeftIndex, int preRightIndex,
                               int inLeftIndex, int inRightIndex) {
        if (preLeftIndex > preRightIndex) {
            return null;
        }
        int rootValue = preorder[preLeftIndex];
        int inMidIndex = 0;
        for (int i = inLeftIndex; i <= inRightIndex; i++) {
            if (inorder[i] == rootValue) {
                inMidIndex = i;
                break;
            }
        }
        int num = inMidIndex - inLeftIndex;
        TreeNode root = new TreeNode(rootValue);

        root.left = buildTree(preorder, inorder, preLeftIndex + 1, preLeftIndex + num, inLeftIndex, inMidIndex - 1);
        root.right = buildTree(preorder, inorder, preLeftIndex + num + 1, preRightIndex, inMidIndex + 1, inRightIndex);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
