package leetcode10;

import java.util.HashSet;

public class Solution2 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

//    public ListNode detectCycle(ListNode head) {
//        if(head == null){
//            return null;
//        }
//        HashSet<ListNode> listNodes = new HashSet<>();
//        while (head != null){
//            if(listNodes.contains(head)){
//                return head;
//            }else {
//                listNodes.add(head);
//            }
//            head = head.next;
//        }
//        return null;
//    }

    // 错误
//    public ListNode detectCycle(ListNode head) {
//        if(head == null){
//            return null;
//        }
//        ListNode fast = head.next, slow = head;
//        while (fast != slow){
//            if(fast == null || fast.next == null){
//                return null;
//            }
//            fast = fast.next.next;
//        }
//        ListNode third = head.next;
//        while (third != slow){
//            slow = slow.next;
//            third = third.next;
//        }
//        return third;
//    }
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast  = head, slow = head;
        while (fast != null){
            if(fast.next == null){
                return null;
            }else{
                fast = fast.next.next;
            }
            slow = slow.next;
            if(fast == slow){
                ListNode temp = head;
                while (head != slow){
                    slow = slow.next;
                    head = head.next;
                }
                return temp;
            }
        }
        return null;
    }
}
