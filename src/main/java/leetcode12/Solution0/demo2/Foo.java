package leetcode12.Solution0.demo2;
/*
    无共享变量
 */
public class Foo {

    // 锁对象
    // 可以处理竞争关系线程的问题
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (this){
            printFirst.run();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (this){
            printSecond.run();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (this){
            printThird.run();
        }
    }
}
