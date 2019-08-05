package 高并发第一阶段.死锁;

public class main {

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
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread() + " get ResourceB");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread() + "waiting get ResourceA");
                    synchronized (resourceA) {
                        System.out.println(Thread.currentThread() + "get ResourceA");
                    }
                }
                ;
            }
        },THREAD_B);

        threadA.start();
        threadB.start();

    }


}