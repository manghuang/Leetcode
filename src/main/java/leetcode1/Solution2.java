package leetcode1;


import java.util.LinkedList;

class Solution2 {
    public static void main(String[] args) {
        int[] a = {7, 2, 4, 3};
        int[] b = {5, 6, 4};
        ListNode l1 = null;
        for (int i = a.length - 1; i >= 0; i--) {
            ListNode ans = new ListNode(a[i]);
            ans.next = l1;
            l1 = ans;
        }
        ListNode l2 = null;
        for (int i = b.length - 1; i >= 0; i--) {
            ListNode ans = new ListNode(b[i]);
            ans.next = l2;
            l2 = ans;
        }
        ListNode l11 = l1;
        while (l11 != null) {
            System.out.print(l11.val + "  ");
            l11 = l11.next;
        }
        System.out.println();
        ListNode l22 = l2;
        while (l22 != null) {
            System.out.print(l22.val + "  ");
            l22 = l22.next;
        }
        System.out.println();
        ListNode result = new Solution2().addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + "  ");
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode result = null;
        int c = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || c != 0) {
            int a1 = 0;
            int a2 = 0;
            if (!stack1.isEmpty()) {
                a1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                a2 = stack2.pop();
            }
            int a = a1 + a2 + c;
            c = a / 10;
            a = a % 10;

            ListNode ans = new ListNode(a);
            ans.next = result;
            result = ans;
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
}