package leetcode12.Solution3.demo2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class H2O {
    /*
        原本：每次只能进入一个，控制什么时候进入，什么时候输出（凑够一组才输出）
        参考：使用信号量控制进入几个，
        想法：不控制进入的个数，控制条件是否等待，以及何时改变条件
     */
    private int hNum = 2;
    private  int oNum = 1;
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        synchronized (this){
            while (hNum == 0){
                wait();
            }
            hNum--;
            releaseHydrogen.run();
            if(hNum == 0 && oNum == 0){
                hNum = 2;
                oNum = 1;
            }
            notifyAll();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (this){
            while (oNum == 0){
                wait();
            }
            oNum--;
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            if(hNum == 0 && oNum == 0){
                hNum = 2;
                oNum = 1;
            }
            notifyAll();
        }

    }

}
