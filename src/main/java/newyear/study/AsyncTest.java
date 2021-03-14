package newyear.study;

import com.sun.xml.internal.ws.util.CompletedFuture;
import org.junit.Test;

import java.util.concurrent.*;

public class AsyncTest {

    @Test
    public void test1(){
        System.out.println(Thread.currentThread().getName());
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            return 10;
        });
        CompletableFuture<String> stringCompletableFuture = completableFuture.thenApply(i -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i.toString();
        });
        CompletableFuture<String> completableFuture1 = stringCompletableFuture.whenComplete((i, t) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(i);
            t.printStackTrace();
        });
//        try {
//            System.out.println(stringCompletableFuture.get()); // 异步非阻塞
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        System.out.println(Thread.currentThread());

        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread());
                Thread.sleep(5000);
                return -1;
            }
        });
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(futureTask);
        try {
            System.out.println(futureTask.get()); // 异步阻塞
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread());

    }

}
