package leetcode12.Solution2.demo3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;


/*
    可以，使用两个共享变量，在同步代码块中同时判断两个条件
 */
public class ZeroEvenOdd {
    private int n;
    private int index = 1;
    private boolean single = false;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 0; i < n ; i++) {
            lock.lock();
            while (single) {
                condition.await();
            }
            printNumber.accept(0);
            single = true;
            condition.signalAll();
            lock.unlock();
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        int temp = n / 2;
        for (int i = 0; i <temp ; i++) {
            lock.lock();
            while (!single || index%2 == 1){
                condition.await();
            }
            printNumber.accept(index);
            index++;
            single = false;
            condition.signalAll();
            lock.unlock();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int temp = n % 2 == 0? n/2: n/2+1;
        for (int i = 0; i <temp ; i++) {
            lock.lock();
            while (!single || index%2 == 0){
                condition.await();
            }
            printNumber.accept(index);
            index++;
            single = false;
            condition.signalAll();
            lock.unlock();

        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(System.out::println);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(System.out::println);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(System.out::println);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
