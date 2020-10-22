package leetcode12.demo4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {
    //等待、通知机制
    //锁对象
    //条件对象
    // 可以处理协作关系线程的问题
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int single = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        lock.lock();
        while (single != 1){
            condition.await();
        }
        printFirst.run();
        single++;
        condition.signalAll();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.

        lock.lock();
        while (single != 2){
            condition.await();
        }
        printSecond.run();
        single++;
        condition.signalAll();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.

        lock.lock();
        while (single != 3){
            condition.await();
        }
        printThird.run();
        single++;
        condition.signalAll();
        lock.unlock();
    }
}
