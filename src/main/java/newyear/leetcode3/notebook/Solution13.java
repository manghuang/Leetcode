package newyear.leetcode3.notebook;

public class Solution13 {

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

        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode pre = new ListNode(0, head);
            ListNode last = pre;
            int index = 1;
            while (index < left){
                index++;
                last = head;
                head = head.next;
            }
            ListNode ll = last;
            ListNode lr = head;
            while (index <= right){
                ListNode temp = head.next;
                head.next = last;
                last = head;
                head = temp;
                index++;
            }
            ListNode rl = last;
            ListNode rr = head;
            ll.next = rl;
            lr.next = rr;

            return pre.next;
        }
    }
