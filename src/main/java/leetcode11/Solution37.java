package leetcode11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution37 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode listNode = head;
        List<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.sort(list);
        listNode = head;
        int index = 0;
        while (listNode != null) {
            listNode.val = list.get(index++);
            listNode = listNode.next;
        }
        return head;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode last = head;
        ListNode cur = last.next;
        while (cur != null){
            if(last.val <= cur.val){
                last = cur;
                cur = cur.next;
            }else{
                ListNode temp = pre;
                while (temp.next.val <= cur.val){
                    temp = temp.next;
                }
                last.next = cur.next;
                cur.next = temp.next;
                temp.next = cur;
                cur = last.next;
            }
        }
        return pre.next;
    }
}
