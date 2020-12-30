package leetcode14;


// 1.单例模式
public class Singleton {
    // 在实例变量上进行初始化
//    private static Singleton singleton = new Singleton();
//    private Singleton(){
//
//    }
//    public static Singleton getSingletop(){
//        return singleton;
//    }
    // 遇到时候进行初始化，给方法加锁
//    private static Singleton singleton;
//    private Singleton(){
//
//    }
//    public synchronized static Singleton getSingleton(){
//        if (singleton == null){
//            singleton = new Singleton();
//        }
//        return singleton;
//    }
    // 第一次遇到进行初始化，双重校验
    private static Singleton singleton;
    private Singleton(){

    }

    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
