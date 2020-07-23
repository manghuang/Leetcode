package leetcode5;

public class Solution8 {

    /*
        方式一：dps+回溯
            剪枝？
            分支定界？
        方式二、bps，较慢  两个队列，一个记录节点，一个记录对应的和
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dps(root, sum, 0);
    }

    private boolean dps(TreeNode root, int sum, int temp) {
        temp += root.val;
        if (root.left == null && root.right == null) {
            return temp == sum;
        }
        if (root.left != null) {
            if (dps(root.left, sum, temp)) {
                return true;
            }
        }
        if (root.right != null) {
            if (dps(root.right, sum, temp)) {
                return true;
            }
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
