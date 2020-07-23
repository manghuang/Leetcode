package leetcode5;

public class Solution3 {

    /*
        有序数组转平衡二叉树，答案不唯一
        只有一个中序遍历+平衡要求  -> 答案不唯一
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return dps(nums, 0, nums.length - 1);
    }

    private TreeNode dps(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = (begin + end) / 2; // 中间或者中间靠左边
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = dps(nums, begin, mid - 1);
        treeNode.right = dps(nums, mid + 1, end);
        return treeNode;
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
