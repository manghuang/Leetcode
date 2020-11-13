package leetcode11;

public class Solution30 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
        不是快慢指针
        而是奇偶指针
     */
//    public ListNode oddEvenList(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode fast = head.next.next;
//        ListNode slow = head.next;
//        while (fast != null){
//            int temp = fast.val;
//            fast.val = slow.val;
//            slow.val = temp;
//            if(fast.next == null){
//                break;
//            }
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        ListNode listNode = slow.next;
//        slow.next = fast;
//        ListNode last = null;
//        while (listNode != null){
//            ListNode next = listNode.next;
//            listNode.next = last;
//            last = listNode;
//            listNode = next;
//        }

    //        return head;
//    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode odd = head;
        while (even != null){
            odd.next = even.next;
            if(even.next == null){
                break;
            }
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }
        odd.next = evenHead;
        return head;
    }
}
