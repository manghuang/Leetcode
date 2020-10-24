package leetcode12.Solution0.demo5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    使用一个共享变量，判断一个条件
 */
public class Foo {
    //等待、通知机制
    //锁对象
    //条件对象
    // 可以处理协作关系线程的问题
    private int single = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (this){
            while (single != 1){
                wait();
            }
            printFirst.run();
            single++;
            notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.

        synchronized (this){
            while (single != 2){
                wait();
            }
            printSecond.run();
            single++;
            notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.

        synchronized (this){
            while (single != 3){
                wait();
            }
            printThird.run();
            single++;
            notifyAll();
        }
    }
}
