package leetcode9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution7 {

    private ArrayList<Integer> res;
    private int maxCount;
    private int count;
    private int num;

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 2, 2};
        TreeNode root = bps(nums);
        int[] res = new Solution7().findMode(root);
        System.out.println(Arrays.toString(res));
    }

    private static TreeNode bps(int[] nums) {
        int index = 0;
        TreeNode root = new TreeNode(nums[index]);
        LinkedList<TreeNode> linkedList = new LinkedList<>();
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
            if (index >= nums.length) {
                break;
            }
            if (nums[index] != -1) {
                TreeNode right = new TreeNode(nums[index]);
                temp.right = right;
                linkedList.offer(right);
            }
            index++;
        }
        return root;
    }

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        res = new ArrayList<>();
        dps(root);
        if (count == maxCount) {
            res.add(num);
        } else if (count > maxCount) {
            res.clear();
            res.add(num);
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void dps(TreeNode root) {
        if (root == null) {
            return;
        }
        dps(root.left);
        if (root.val == num) {
            count++;
        } else {
            if (count == maxCount) {
                res.add(num);
            } else if (count > maxCount) {
                res.clear();
                res.add(num);
                maxCount = count;
            }
            num = root.val;
            count = 1;
        }
        dps(root.right);
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
