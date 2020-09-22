package leetcode9;

import java.util.HashMap;
import java.util.LinkedList;


/*
    dps+return+状态容器
    与以往的不同：以前的数据都是一个数组，在dps过程中就可能会存在重复计算，所以需要状态数组或者可以用动态规划，但是这个本来就是一个树
    角度不一样，自己的思路是面向过程的，需要此节点的什么状态查什么，有下有上，需要记录状态
    而答案的思路是面向节点的，一次性返回此节点在三个状态下的值，从下向上，不需要记录状态，等价与动态规划
 */
public class Solution6 {


    /*
          f  f  0
          f  t  1
          t  f  2

     */
    private HashMap<TreeNode, Integer[]> table = new HashMap<>();

    public static void main(String[] args) {
        int[] nums = {0, 0, -1, 0, 0};
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        TreeNode root = bps(linkedList, nums);
        int res = new Solution6().minCameraCover(root);
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
            if (nums[index] != -1) {
                TreeNode right = new TreeNode(nums[index]);
                temp.right = right;
                linkedList.offer(right);
            }
            index++;
        }
        return root;
    }

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dps(root, 0);

    }

    private int dps(TreeNode root, int index) {
        if (root == null) {
            if (index == 1) {
                return 1;
            }
            return 0;
        }

        int res;
        int left = getNum(root.left, 2);
        int right = getNum(root.right, 2);
        res = left + right + 1;

        if (index == 2 || index == 0) {
            int leftNotSetCamera = getNum(root.left, 0);
            int rightNotSetCamera = getNum(root.right, 0);
            if (index == 2) {
                res = Math.min(res, leftNotSetCamera + rightNotSetCamera);
            }
            if (index == 0) {
                int leftWhenLeft = getNum(root.left, 1);
                int rightWhenRight = getNum(root.right, 1);
                res = Math.min(res, Math.min(leftWhenLeft + rightNotSetCamera, leftNotSetCamera + rightWhenRight));
            }
        }
        return res;
    }

    private int getNum(TreeNode root, int index) {
        int num;
        if (table.containsKey(root)) {
            if (table.get(root)[index] != -1) {
                num = table.get(root)[index];
            } else {
                num = dps(root, index);
                table.get(root)[index] = num;
            }
        } else {
            Integer[] temp = {-1, -1, -1};
            num = dps(root, index);
            temp[index] = num;
            table.put(root, temp);
        }
        return num;
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
