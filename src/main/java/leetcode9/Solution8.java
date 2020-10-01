package leetcode9;

public class Solution8 {


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        return dps(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode dps(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        int val = postorder[postRight];
        int index = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        int num = postLeft + index - 1 - inLeft;
        root.left = dps(inorder, inLeft, index - 1, postorder, postLeft, num);
        root.right = dps(inorder, index + 1, inRight, postorder, num + 1, postRight - 1);
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
