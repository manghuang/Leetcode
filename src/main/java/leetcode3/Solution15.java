package leetcode3;

import java.util.LinkedList;
import java.util.Objects;

/*
    二叉树的遍历以及根据遍历结果的重建
    遍历：层序遍历、前序遍历+中序遍历，后序遍历+中序遍历
    重建
 */
public class Solution15 {

    public static void main(String[] args) {
        String str = "1,2,3,n,n,4,5,n,n,n,n";
        Solution15 solution15 = new Solution15();
        TreeNode treeNode = solution15.deserialize(str);
        String res = solution15.serialize(treeNode);
        System.out.println(res);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        return bps(root);
    }

    private String bps(TreeNode root) {
        if (root == null) {
            return "";
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);
        StringBuilder res = new StringBuilder();
        while (!linkedList.isEmpty()) {
            TreeNode treeNode = linkedList.remove();
            if (treeNode == null) {
                res.append('n');
                res.append(',');
            } else {
                res.append(treeNode.val);
                res.append(',');
                linkedList.offer(treeNode.left);
                linkedList.offer(treeNode.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || Objects.equals(data, "")) {
            return null;
        }
        return buildTree(data);
    }

    private TreeNode buildTree(String data) {

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        int index = 0;
        TreeNode root = new TreeNode();

        index = method(root, index, data, linkedList);


        while (!linkedList.isEmpty()) {
            TreeNode treeNode = linkedList.remove();
            if (data.charAt(index) == 'n') {
                treeNode.left = null;
                index += 2;
            } else {
                treeNode.left = new TreeNode();
                index = method(treeNode.left, index, data, linkedList);
            }
            if (data.charAt(index) == 'n') {
                treeNode.right = null;
                index += 2;
            } else {
                treeNode.right = new TreeNode();
                index = method(treeNode.right, index, data, linkedList);
            }
        }
        return root;
    }

    private int method(TreeNode treeNode, int index, String data, LinkedList<TreeNode> linkedList) {
        int end = data.indexOf(',', index);
        int num = Integer.parseInt(data.substring(index, end));
        treeNode.val = num;
        linkedList.offer(treeNode);
        return end + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }
    }
}
