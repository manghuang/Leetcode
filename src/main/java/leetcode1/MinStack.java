package leetcode1;

import java.util.LinkedList;

public class MinStack {
    LinkedList<Integer> list;
    LinkedList<Integer> minList;

    public MinStack() {
        this.list = new LinkedList<>();
        this.minList = new LinkedList<>();
    }

    public void push(int x) {
        list.push(x);
        if (minList.peek() == null) {
            minList.push(x);
        } else {
            int temp = minList.peek();
            if (x <= temp) {
                minList.push(x);
            } else {
                minList.push(temp);
            }
        }
    }

    public void pop() {
        list.pop();
        minList.pop();
    }

    public int top() {
        return list.peek();
    }

    public int getMin() {
        return minList.peek();
    }
}
