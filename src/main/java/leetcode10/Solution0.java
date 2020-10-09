package leetcode10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution0 {


    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    /*
        方法一：哈希表
        方法二：快慢指针，Floyd判圈算法
     */
//    public boolean hasCycle(ListNode head) {
//        if(head == null){
//            return false;
//        }
//        Set<ListNode> nodes = new HashSet<>();
//        while (head != null){
//            if(nodes.contains(head)){
//                return true;
//            }else {
//                nodes.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
