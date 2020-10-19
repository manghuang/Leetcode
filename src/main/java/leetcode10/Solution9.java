package leetcode10;

public class Solution9 {



      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    private int res;
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        dps(root, root.val);
        return res;
    }

    private void dps(TreeNode root, int maxNum) {
        if(root == null){
            return;
        }
        if(root.val >= maxNum){
            maxNum = root.val;
            res++;
        }
        dps(root.left, maxNum);
        dps(root.right, maxNum);
    }
}
