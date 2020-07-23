package leetcode5;

import java.util.LinkedList;

public class CQueue {

    private LinkedList<Integer> linkedList1;
    private LinkedList<Integer> linkedList2;

    public CQueue() {
        this.linkedList1 = new LinkedList<>();
        this.linkedList2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        linkedList2.push(value);
    }

    public int deleteHead() {
        if (linkedList1.isEmpty()) {
            if (linkedList2.isEmpty()) {
                return -1;
            } else {
                while (!linkedList2.isEmpty()) {
                    linkedList1.push(linkedList2.pop());
                }
                return linkedList1.pop();
            }
        } else {
            return linkedList1.pop();
        }
    }

}
