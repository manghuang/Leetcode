package leetcode12.Solution3.demo1;

public class H2O {
    //以下写法是固定死顺序的
    private  int single = 0;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (this){
            while (single != 0 &&  single != 1){
                wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            single++;
            notifyAll();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        synchronized (this){
            while (single != 2){
                wait();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            single = 0;
            notifyAll();
        }

    }
}
