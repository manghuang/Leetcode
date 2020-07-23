package leetcode6;

import java.util.ArrayList;
import java.util.List;

public class Solution9 {

    public List<TreeNode> generateTrees(int n) {

        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
        return dps(1, n);
    }


      /*
            方式一：dps（递归）+迭代
                    从上向下
                    基本类型   读  写到容器
                    对象  读
                 !  对象  写到容器   字符串/树       很难处理，难在对象的复制是复制地址，最后加入容器中所有的对象都是一个地址
            方式二：dps（递归）+回溯+迭代
                    从下向上
                    拼接树
       */

    private List<TreeNode> dps(int left, int right) {
        List<TreeNode> list = new ArrayList<>();
        if (left > right) {
            list.add(null);
            return list;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftList = dps(left, i - 1);
            List<TreeNode> rightList = dps(i + 1, right);
            for (TreeNode leftNode : leftList
            ) {
                for (TreeNode rightNode : rightList
                ) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    list.add(node);
                }
            }
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
