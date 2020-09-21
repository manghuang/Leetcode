package leetcode9;

public class Solution5 {

    /*
        前序遍历
        中序遍历
        后序遍历
        反序中序遍历

        用一个实例变量记录大于的数就可以了，还避免了返回的麻烦
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        dps(root, 0);
        return root;
    }


//    public TreeNode convertBST(TreeNode root) {
//        if(root == null){
//            return null;
//        }
//        LinkedList<TreeNode> linkedList = new LinkedList<>();
//        dps(root, linkedList);
//        return root;
//    }
//
//    private void dps(TreeNode root, LinkedList<TreeNode> linkedList) {
//          if(root == null){
//              return;
//          }
////          adjust(linkedList, root);
//          dps(root.left, linkedList);
//          dps(root.right, linkedList);
//    }

//    private void adjust(LinkedList<TreeNode> linkedList, TreeNode root){
//
//        int index = 0;
//        int temp = 0;
//        boolean isStart = true;
//        for (int i = 0; i < linkedList.size() ; i++) {
//            TreeNode treeNode = linkedList.get(i);
//            if(treeNode.val < root.val){
//                treeNode.val += root.val;
//            }else if(treeNode.val > root.val){
//                if(isStart){
//                    index = i;
//                    isStart = false;
//                }
//                temp += treeNode.val;
//            }
//        }
//        root.val += temp;
//        linkedList.add(index, root);
//    }

//    public TreeNode convertBST(TreeNode root) {
//        if(root == null){
//            return null;
//        }
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        dps1(root, arrayList);
//        Collections.sort(arrayList);
//        dps2(root, arrayList);
//        return root;
//    }
//
//    private void dps2(TreeNode root, ArrayList<Integer> arrayList) {
//        if(root == null){
//            return;
//        }
//        for (int num:
//             arrayList) {
//            if(num>root.val){
//                root.val += num;
//            }
//        }
//        dps2(root.left, arrayList);
//        dps2(root.right, arrayList);
//    }
//
//    private void dps1(TreeNode root, ArrayList<Integer> arrayList) {
//          if(root == null){
//              return;
//          }
//          arrayList.add(root.val);
//          dps1(root.left, arrayList);
//          dps1(root.right, arrayList);
//    }

    private int dps(TreeNode root, int num) {
        if (root == null) {
            return num;
        }
        int rightNum = dps(root.right, num);
        root.val += rightNum;
        int leftNum = dps(root.left, root.val);
        return leftNum;
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
