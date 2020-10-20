package leetcode11;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        List<ListNode> listNodes = new ArrayList<>();
        ListNode p = head;
        while (p != null){
            listNodes.add(p);
            p = p.next;
        }
        int left = 0;
        int right = listNodes.size()-1;
        p = head;
        while (left < right){
            ListNode front = p.next;
            ListNode behind = listNodes.get(right);
            p.next = behind;
            behind.next = front;
            p = front;
            left++;
            right--;
        }
        p.next = null;
    }
}
