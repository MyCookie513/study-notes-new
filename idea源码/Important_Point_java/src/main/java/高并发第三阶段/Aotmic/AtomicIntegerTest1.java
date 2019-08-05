package 高并发第三阶段.Aotmic;

import 高并发第三阶段.Aotmic.CAS创建一个Lock.CompareAndSetlock;
import 高并发第三阶段.Aotmic.CAS创建一个Lock.GetLockException;

public class AtomicIntegerTest1 {
    private final static CompareAndSetlock compareAndSetlock=new CompareAndSetlock();


    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(()->{
                try {
                    doSomething2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (GetLockException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
    public static void doSomething() throws InterruptedException{
        synchronized (AtomicIntegerTest1.class){
            System.out.println(Thread.currentThread().getName()+" get the Lock  ");
            Thread.sleep(10000);
        }
    }
    public static void doSomething2() throws InterruptedException, GetLockException {

        try{
            compareAndSetlock.tryLock();
            Thread.sleep(10000);
        }finally {
            compareAndSetlock.unLock();
        }


    }
}
