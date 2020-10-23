package leetcode11;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int right = list.size()-1;
        int left = 0;
        while(left < right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
          int[] nums = {-129, -129};
          int index = 0;
          ListNode pre = new ListNode(-1);
          ListNode head = pre;
          while (index < nums.length){
              head.next = new ListNode(nums[index]);
              head = head.next;
              index++;
          }
        boolean res = new Solution4().isPalindrome(pre.next);
        System.out.println(res);
    }
}
