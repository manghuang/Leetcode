package leetcode11;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution10 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    private int res = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root,  new ArrayList<Integer>());
        return res;
    }

    private void dfs(TreeNode root, ArrayList<Integer> list) {
        list.add(root.val);
        if(root.left == null && root.right == null){
            int temp = 0;
            int size = list.size();
            for (int i = 0; i <size ; i++) {
                temp += list.get(i)*Math.pow(10,size-1-i);
            }
            res += temp;
            list.remove(list.size()-1);
            return;
        }
        if(root.left != null){
            dfs(root.left, list);
        }
        if(root.right != null){
            dfs(root.right, list);
        }
        list.remove(list.size()-1);
    }
}
