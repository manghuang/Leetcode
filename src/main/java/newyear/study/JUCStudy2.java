package newyear.study;

import java.util.concurrent.*;

public class JUCStudy2 {

    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1));

        for (int i = 0; i < 4; i++) {
            try{
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            threadPoolExecutorState(executor);
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                        System.out.println("execute:" + "线程" + Thread.currentThread().getName());
                    }
                });
            }catch (RejectedExecutionException ex){
                ex.printStackTrace();
            }
        }
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
        executor.shutdown();
    }

    public static void threadPoolExecutorState(ThreadPoolExecutor executor){
        LinkedBlockingQueue queue = (LinkedBlockingQueue) executor.getQueue();
        System.out.println(
                Thread.currentThread().getName() + "-" +
                "  核心线程数：" + executor.getCorePoolSize()
                + "  活动线程数：" + executor.getActiveCount()
                + "  最大线程数" + executor.getMaximumPoolSize()
                + "  队列完成数：" + executor.getCompletedTaskCount()
                + "  当前队列中任务数" + queue.size()
                + "  队列剩余大小" + queue.remainingCapacity()
        );
    }
}
