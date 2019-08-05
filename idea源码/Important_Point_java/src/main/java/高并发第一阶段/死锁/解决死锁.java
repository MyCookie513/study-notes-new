package 高并发第一阶段.死锁;


/**
 * 通过改变资源获取的顺序从而解决死锁的问题
 */
public class 解决死锁 {

    private static Object resourceA = new Object();
    private static Object resourceB = new Object();
    private static String THREAD_A = "thread-A";
    private static String THREAD_B = "thread-B";

    public static void main(String[] ar) {

        // 创建线程 A
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + " get ResourceA");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + "waiting get ResourceB");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread() + "get ResourceB");
                    }
                }
                ;
            }
        },THREAD_A);

        // 创建线程 B
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread() + " get ResourceA");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + "waiting get ResourceB");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread() + "get ResourceB");
                    }
                }
                ;
            }
        },THREAD_B);

        threadA.start();
        threadB.start();

    }


}
