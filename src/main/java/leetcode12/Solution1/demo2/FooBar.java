package leetcode12.Solution1.demo2;
/*
    使用一个共享变量，判断一个条件
 */
public class FooBar {

    private int n;
    private boolean single = false;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {


        for (int i = 0; i < n; i++) {
           synchronized (this){
               while (single){
                   wait();
               }
               // printFoo.run() outputs "foo". Do not change or remove this line.
               printFoo.run();
               single = true;
               notifyAll();
           }


        }

    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this){
                while (!single){
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                single = false;
                notifyAll();
            }
        }

    }
}
