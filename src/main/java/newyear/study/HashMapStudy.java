package newyear.study;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapStudy {

    public static void main(String[] args) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        hashMap.put(1,1);

//        ExecutorService service = Executors.newFixedThreadPool(1);
//        for (int i = 0; i < 5; i++) {
//            service.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("execute:" + "线程" + Thread.currentThread().getName());
//                }
//            });
//        }
//        Future<Integer> future= service.submit(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("submit:" + "线程" + Thread.currentThread().getName());
//                return 1;
//            }
//        });
//
//        try {
//            System.out.println(future.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        if(future.isDone()){
//            System.out.println("Done");
//        }else {
//            System.out.println("canceled");
//        }
//
//        service.shutdown();

        AtomicInteger atomicInteger = new AtomicInteger(1);
        boolean b = atomicInteger.compareAndSet(0, 2);
        System.out.println(b);

    }
}
