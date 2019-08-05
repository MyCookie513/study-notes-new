package 高并发第二阶段.waitSet;


/***
 * 1.所有的对象都会有一个waitset 来维护拥有这个锁，但调用了wait方法之后的 进入了block方法的线程；
 *  拟人： 所有的对象都是一个鸡  ；以前的人都曾拥有这个鸡，
 *  2.线程被notify后，不一定能立即执行，他首先需要得到这个锁的拥有权，才能继续向下执行；
 *  3.线程在waitset唤醒的顺序不是FIFO队列；
 *  
 */
public class WaitSet {


    private static final  Object Lock =new Object();


    static  void work() {
        synchronized (Lock){
            System.out.println("获取到这个对象的拥有权");
            try {
                System.out.println("将这个线程加入到这个对象的wait set 队列  ");
                Lock.wait();
                System.out.println(" 这个线程被唤醒 从wait  set 中移除      ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            work();
        }).start();
        Thread.sleep(1000);

        synchronized (Lock){
            Lock.notify();
        }


    }




}
