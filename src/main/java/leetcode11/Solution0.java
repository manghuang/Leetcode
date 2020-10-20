package leetcode11;

import java.util.ArrayList;
import java.util.List;

public class Solution0 {

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
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        dps(root, list);
        return res;
    }

    private void dps(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if(root.left == null && root.right == null){
            // 判断这个排列是不是存在序列满足回文

            list.remove(list.size()-1);
            return;
        }
        if(root.left != null){
            dps(root.left,list);
        }
        if(root.right!= null){
            dps(root.right, list);
        }
        list.remove(list.size()-1);
    }
}
