package leetcode4;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution2 {
    public static void main(String[] args) {
        String str = "1-2--3---4-5--6---7";
        new Solution2().recoverFromPreorder(str);
    }

    public TreeNode recoverFromPreorder(String S) {

        if (S == null || S.length() == 0) {
            return null;
        }

        HashMap<Integer, LinkedList<Integer>> hashMap = new HashMap<>();
        int deep = 0;
        int beginIndex = 0;
        boolean isok = false;
        for (int i = 0; i <= S.length(); i++) {
            if (!isok) {
                if (S.charAt(i) == '-') {
                    deep++;
                } else {
                    beginIndex = i;
                    isok = true;
                }
            } else {
                if (i == S.length() || S.charAt(i) == '-') {
                    int num = Integer.parseInt(S.substring(beginIndex, i));
                    if (hashMap.containsKey(deep)) {
                        LinkedList<Integer> linkedList = hashMap.get(deep);
                        linkedList.offer(num);
                    } else {
                        LinkedList<Integer> linkedList = new LinkedList<>();
                        linkedList.offer(num);
                        hashMap.put(deep, linkedList);
                    }
                    isok = false;
                    deep = 1;
                }
            }
        }
        System.out.println(hashMap);
        return dps(hashMap, 0);
    }

    private TreeNode dps(HashMap<Integer, LinkedList<Integer>> hashMap, int deep) {
        if (!hashMap.containsKey(deep)) {
            return null;
        }
        LinkedList<Integer> linkedList = hashMap.get(deep);
        if (linkedList.size() == 0) {
            return null;
        }
        int val = linkedList.remove();
        TreeNode root = new TreeNode(val);
        root.left = dps(hashMap, deep + 1);
        root.right = dps(hashMap, deep + 1);
        return root;
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
