package leetcode14;

public class Solution6 {

    private static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        System.out.println("!");
        ListNode revHead1 = reverse(head1);
        ListNode revHead2 = reverse(head2);
        ListNode res = new ListNode(-1);
        ListNode pre = res;
        int temp = 0;
        System.out.println("!");
        while(revHead1 != null && revHead2 != null){
            int val = revHead1.val + revHead2.val + temp;
            if(val >= 10){
                temp = 1;
                pre.next = new ListNode(val-10);
            }else{
                temp = 0;
                pre.next = new ListNode(val);
            }
            pre = pre.next;
            revHead1 = revHead1.next;
            revHead2 = revHead2.next;
        }
        System.out.println("!");
        while(revHead1 != null){
            int val = revHead1.val + temp;
            if(val >= 10){
                temp = 1;
                pre.next = new ListNode(val-10);
            }else{
                temp = 0;
                pre.next = new ListNode(val);
            }
            pre = pre.next;
            revHead1 = revHead1.next;
        }
        System.out.println("!");
        while(revHead2 != null){
            int val = revHead2.val + temp;
            if(val >= 10){
                temp = 1;
                pre.next = new ListNode(val-10);
            }else{
                temp = 0;
                pre.next = new ListNode(val);
            }
            pre = pre.next;
            revHead2 = revHead2.next;
        }
        return reverse(res.next);
    }

    private ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        ListNode pre = head;
        head = pre.next;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode temp1 = head1;
        temp1.next = new ListNode(2);
        ListNode head2 = new ListNode(1);
        ListNode temp2 = head2;
        temp2.next = new ListNode(2);
        ListNode listNode = new Solution6().addInList(head1, head2);

    }
}
