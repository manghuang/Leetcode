package leetcode12.Solution2.demo2;

import java.util.function.IntConsumer;


public class ZeroEvenOdd {
    private int n;
    private int index = 1;
    private volatile int single = 1;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 0; i < n ; i++) {
            while (single != 1 && single != 3) {
               Thread.yield();
            }
            printNumber.accept(0);
            if(single == 1){
                single = 2;
            }else {
                single = 4;
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        int temp = n / 2;
        for (int i = 0; i <temp ; i++) {
            while (single != 4){
                Thread.yield();
            }
            printNumber.accept(index);
            index++;
            single = 1;
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int temp = n % 2 == 0? n/2: n/2+1;
        for (int i = 0; i <temp ; i++) {
            while (single != 2){
                Thread.yield();
            }
            printNumber.accept(index);
            index++;
            single = 3;
        }
    }
}
