package leetcode12.Solution1.demo3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
    使用一个共享变量，判断一个条件
 */
public class FooBar {

    private int n;
    private boolean single = false;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {


        for (int i = 0; i < n; i++) {
            lock.lock();
            while (single){
               condition.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            single = true;
            condition.signalAll();
            lock.unlock();

        }

    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            while (!single){
                condition.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printBar.run();
            single = false;
            condition.signalAll();
            lock.unlock();

        }

    }
}
