package leetcode4;

import java.util.HashSet;

public class Solution12 {

    /*
        方式一：链表转list,去重,转链表
        方式二：直接在链表上操作,去重
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        ListNode pre = head;
        ListNode next = pre.next;
        hashSet.add(pre.val);
        while (next != null) {
            if (hashSet.contains(next.val)) {
                pre.next = next.next;
            } else {
                hashSet.add(next.val);
                pre = pre.next;
            }
            next = pre.next;
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
