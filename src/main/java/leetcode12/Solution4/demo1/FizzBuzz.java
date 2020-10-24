package leetcode12.Solution4.demo1;

import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;
    private int index = 1;
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this){
            while (index <= n){
                if (index % 3 != 0 || index % 5 == 0){
                    wait();
                }else {
                    printFizz.run();
                    index++;
                    notifyAll();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this){
            while (index <= n){
                if (index % 3 == 0 || index % 5 != 0){
                    wait();
                }else {
                    printBuzz.run();
                    index++;
                    notifyAll();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this){
            while (index <= n){
                if (index % 3 != 0 || index % 5 != 0){
                    wait();
                }else {
                    printFizzBuzz.run();
                    index++;
                    notifyAll();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this){
            while (index <= n){
                if (index % 3 == 0 || index % 5 == 0){
                    wait();
                }else {
                    printNumber.accept(index);
                    index++;
                    notifyAll();
                }
            }
        }
    }
}
