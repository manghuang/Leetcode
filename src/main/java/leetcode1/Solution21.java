package leetcode1;

public class Solution21 {
    public static void main(String[] args) {
        ListNode hair = new ListNode(0);
        ListNode pre = hair;
        int[] nums = {1, 2, 3, 4, 5};
        for (int num : nums
        ) {
//            System.out.println(num);
            pre.next = new ListNode(num);
            pre = pre.next;
        }
        ListNode listNode = hair.next;
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        listNode = new Solution21().reverseKGroup(hair.next, 2);
        System.out.println("=============================");
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//        if(k == 1){
//            return head;
//        }
//        int endIndex;
//        ListNode begin = head;
//        ListNode end = head;
//        ListNode lastEnd = head;
//        boolean isok = false;
//        while (end != null){
//            endIndex = 1;
//            while(endIndex < k && end.next != null){
//                end = end.next;
//                endIndex++;
//            }
//            if(endIndex == k){
//                ListNode temp = begin.next;
//                begin.next = end.next;
//                end.next = begin;
//                while (temp != end){
//                    ListNode ln = temp.next;
//                    temp.next = end.next;
//                    end.next = temp;
//                    temp = ln;
//                }
//                if(!isok){
//                    head = end;
//                    isok = true;
//                }else{
//                    lastEnd.next = end;
//                }
//            }else{
//                break;
//            }
//            end = begin.next;
//            lastEnd = begin;
//            begin  = begin.next;
//        }
//
//        return head;
//    }

    /**
     * pre (head ...  tail)(k)  end
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }
        ListNode hair = new ListNode(0);
        hair.next = head;

        ListNode pre = hair;
        ListNode tail = pre;
        ListNode end;
        int num;
        while (tail != null) {
            num = 0;
            while (num < k && tail.next != null) {
                tail = tail.next;
                num++;
            }
            if (num == k) {
                end = tail.next;
                //head ... tail
                this.reverse(head, tail);
                pre.next = tail;
                head.next = end;
            } else {
                break;
            }
            pre = head;
            head = pre.next;
            tail = pre;
        }

        return hair.next;
    }

    private void reverse(ListNode head, ListNode tail) {
        tail.next = head;
        while (head.next != tail) {
            ListNode listNode = head.next;
            head.next = listNode.next;
            listNode.next = tail.next;
            tail.next = listNode;

        }
//        System.out.println(1);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
