package leetcode12.demo1;

public class Foo {
    private volatile int single = 1;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while(single < 4){
            if(single == 1){
                printFirst.run();
                single = 2;
            }
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(single < 4){
            if(single == 2){
                printSecond.run();
                single = 3;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(single < 4){
            if(single == 3){
                printThird.run();
                single = 4;
            }
        }

    }
}
