package leetcode12.Solution3.demo2;

public class H2O {

    //没有顺序
    //怎么限制进入的线程个数？
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {


            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();



    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {



            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();



    }
}
