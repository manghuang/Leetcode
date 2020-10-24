package leetcode12.Solution2.demo4;

import java.util.function.IntConsumer;

/*
    可以，使用一个共享变量，在同步代码块中同时判断两个条件
 */
public class ZeroEvenOdd {
    private int n;
    private int index = 1;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 0; i < n ; i++) {
            synchronized (this) {
                while (index%2 != 1) {
                    wait();
                }
                printNumber.accept(0);
                index++;
                notifyAll();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        int temp = n / 2;
        for (int i = 0; i <temp ; i++) {
            synchronized (this){
                while (index%2 != 0 || index%4 != 0){
                    wait();
                }
                printNumber.accept(index / 2);
                index++;
                notifyAll();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int temp = n % 2 == 0? n/2: n/2+1;
        for (int i = 0; i <temp ; i++) {
            synchronized (this){
                while (index%2 != 0 || index % 4 == 0){
                    wait();
                }
                printNumber.accept(index / 2);
                index++;
                notifyAll();
            }
        }
    }
}
