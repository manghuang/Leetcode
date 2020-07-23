package leetcode4;

public class Solution5 {

    /*
        方式一：树转图，枚举所有路径，从中选出一条路径，满足路径上节点的值加起来最大
        方式二：直接在树上操作，递归，从底下向上回溯。
               前提：对于一个节点a,值为A,从左节点b返回的值为B,从右节点c返回的值为C
               计算：1、res = Math.max(res, A+B+C，A+B, A+C, A)
                    2、return Math.max(A+B, A+C, A)
     */
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dps(root);
        return this.res;
    }

    private int dps(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        int left = dps(root.left);
        int right = dps(root.right);
        int temp1 = Math.max(Math.max(val + left, val + right), val);
        int temp2 = Math.max(temp1, val + left + right);
        this.res = Math.max(this.res, temp2);
        return temp1;
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
