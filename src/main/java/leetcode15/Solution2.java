package leetcode15;

public class Solution2 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode node1 = new ListNode(-1);
        node1.next = head;
        ListNode  pre=  node1;
        ListNode node2 = node1;
        while (head != null){
            if(head.val >= x){
                pre = head;
                head = head.next;
            }else {
                if(pre == node2){
                    node2 = head;
                    pre = head;
                    head = head.next;
                }else {
                    ListNode temp = head;
                    pre.next = head.next;
                    head = head.next;
                    temp.next = node2.next;
                    node2.next = temp;
                    node2 = temp;
                }
            }
        }
        return node1.next;
    }
}
