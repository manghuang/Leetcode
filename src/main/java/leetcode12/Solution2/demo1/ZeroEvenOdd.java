package leetcode12.Solution2.demo1;

import java.util.function.IntConsumer;

/*
    可以，使用两个共享变量，在同步代码块中同时判断两个条件
 */
public class ZeroEvenOdd {
    private int n;
    private int index = 1;
    private boolean single = false;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 0; i < n ; i++) {
            synchronized (this) {
                while (single) {
                    wait();
                }
                printNumber.accept(0);
                single = true;
                notifyAll();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        int temp = n / 2;
        for (int i = 0; i <temp ; i++) {
            synchronized (this){
                while (!single || index%2 == 1){
                    wait();
                }
                printNumber.accept(index);
                index++;
                single = false;
                notifyAll();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int temp = n % 2 == 0? n/2: n/2+1;
        for (int i = 0; i <temp ; i++) {
            synchronized (this){
                while (!single || index%2 == 0){
                    wait();
                }
                printNumber.accept(index);
                index++;
                single = false;
                notifyAll();
            }
        }
    }
}
