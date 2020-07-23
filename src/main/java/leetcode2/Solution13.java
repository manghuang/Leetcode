package leetcode2;

public class Solution13 {

    /*
     * 构建二叉树：
     *      1、从层序遍历构建二叉树
     *      2、从先序遍历和中序遍历构建二叉树
     *      3、从中序遍历和后序遍历构建二叉树
     * 遍历二叉树：
     *      1、先序遍历/中序遍历/后序遍历
     *              dps/递归/栈
     *      2、层序遍历
     *              bps/迭代/队列
     */
    /*
        判断对称，可以层序遍历后得到一个数组，比较对应节点是否相等
     */
    /*
          1
        2   2
      2  n 2  n
     */
//    public boolean isSymmetric(TreeNode root) {
//        ArrayList<Integer> pre = new ArrayList<>();
//        ArrayList<Integer> post = new ArrayList<>();
//        preorerTrave(root, pre);
//        postorderTrave(root, post);
//        System.out.println(Arrays.toString(pre.toArray()));
//        System.out.println(Arrays.toString(post.toArray()));
//        for(int i=0; i<pre.size(); i++){
//            if(pre.get(i) == null){
//                if(post.get(i)!=null){
//                    return false;
//                }
//            }else {
//                if(!pre.get(i).equals(post.get(i))){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    private void postorderTrave(TreeNode root, ArrayList<Integer> post) {
//        if(root == null){
//            post.add(null);
//            return;
//        }
//
//        postorderTrave(root.right, post);
//        post.add(root.val);
//        postorderTrave(root.left, post);
//
//    }
//
//    private void preorerTrave(TreeNode root, ArrayList<Integer> pre) {
//        if(root == null){
//            pre.add(null);
//            return;
//        }
//        preorerTrave(root.left, pre);
//        pre.add(root.val);
//        preorerTrave(root.right, pre);
//    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
