package leetcode10;

public class Solution5 {


    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n < 0){
            return null;
        }
        int length = 0;
        ListNode p = new ListNode(-1);
        p.next = head;
        while (head != null){
            length++;
            head = head.next;
        }
        int temp = length - n;
//        if(temp == 0){
//            p.next = p.next.next;
//        }else {
//            head = p;
//            while (temp > 0){
//                temp--;
//                head = head.next;
//            }
//            head.next = head.next.next;
//        }
        head = p;
        while (temp > 0){
            temp--;
            head = head.next;
        }
        head.next = head.next.next;
        return p.next;
    }
}
