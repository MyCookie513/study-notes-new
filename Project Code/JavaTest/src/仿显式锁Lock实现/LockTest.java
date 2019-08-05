package 仿显式锁Lock实现;

import java.util.stream.Stream;

public class LockTest {


    public static void main(String[] args) {

        final  BooleanLock booleanLock=new BooleanLock();
        Stream.of("T1","T2","T3","T5").forEach(name->{
            new Thread(()->{
                try {
                    booleanLock.lock(3000);
                    System.out.println(Thread.currentThread().getName()+" 抢到了显示Lock");
                    working();
                } catch (InterruptedException | Lock.TimeoutException0 e) {
                    System.out.println(Thread.currentThread().getName()+"  time  out");
                }finally {
                    booleanLock.unlock();
                }
            },name).start();
        });

    }

    public static void working () throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"  running !");
        Thread.sleep(6000);
    }
}
