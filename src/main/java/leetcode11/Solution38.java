package leetcode11;

public class Solution38 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int num;
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return num;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        num++;
        dfs(root.left);
        dfs(root.right);
    }
}
