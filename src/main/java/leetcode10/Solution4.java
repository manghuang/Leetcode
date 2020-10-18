package leetcode10;

import leetcode9.Solution6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution4 {

      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
     }

    private int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return -1;
        }
         dps(root, -1);
        return res;
    }

    private int dps(TreeNode root, int val) {
        int leftValue = -1;
        int rightValue = root.val;
        if(root.left != null){
            leftValue = dps(root.left, val);
        }
        if(leftValue != -1){
            res = Math.min(res, root.val - leftValue);
        }else {
            if(val != -1){
                res = Math.min(res, root.val-val);
            }
        }
        if(root.right != null){
            rightValue = dps(root.right, root.val);
        }
        return rightValue;
    }

    public static void main(String[] args) {
        int[] nums = {1,-1, 5, 3};
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode root = bps(linkedList, nums);
        int res = new Solution4().getMinimumDifference(root);
        System.out.println(res);
    }

    private static TreeNode bps(LinkedList<TreeNode> linkedList, int[] nums) {
        int index = 0;
        TreeNode root = new TreeNode(nums[index]);
        linkedList.offer(root);
        index++;
        while (index < nums.length) {
            TreeNode temp = linkedList.remove();
            if (nums[index] != -1) {
                TreeNode left = new TreeNode(nums[index]);
                temp.left = left;
                linkedList.offer(left);
            }
            index++;
            if (index < nums.length && nums[index] != -1) {
                TreeNode right = new TreeNode(nums[index]);
                temp.right = right;
                linkedList.offer(right);
            }
            index++;
        }
        return root;
    }
}
