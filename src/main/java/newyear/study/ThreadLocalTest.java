package newyear.study;

public class ThreadLocalTest{

    private static   ThreadLocal<String> str = new ThreadLocal<>();

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(str.get());
        str.set("123");
        System.out.println(str.get());
        str.remove();
        System.out.println(str.get());
       new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println(Thread.currentThread().getName());
               System.out.println(str.get());
               str.set("1");
               System.out.println(str.get());
           }
       }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(str.get());
                str.set("2");
                System.out.println(str.get());
            }
        }).start();

    }
}
