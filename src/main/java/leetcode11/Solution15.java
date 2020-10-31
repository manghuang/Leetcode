package leetcode11;

public class Solution15 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    private ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution15(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int index = 1;
        ListNode temp = head;
        int res = temp.val;
        while (temp != null){
            boolean success = (int) (Math.random() * index) == 0;
            if(success){
                res = temp.val;
            }
            temp = temp.next;
            index++;
        }
        return res;
    }
}
