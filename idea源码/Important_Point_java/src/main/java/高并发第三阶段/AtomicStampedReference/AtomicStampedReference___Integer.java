package 高并发第三阶段.AtomicStampedReference;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReference___Integer {
    static AtomicStampedReference<Integer> atomicStampedSimple=new AtomicStampedReference<>(100,0);

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    boolean success= atomicStampedSimple.compareAndSet(100,101,atomicStampedSimple.getStamp(),atomicStampedSimple.getStamp()+1);
                    System.out.println(success);
                    success= atomicStampedSimple.compareAndSet(101,100,atomicStampedSimple.getStamp(),atomicStampedSimple.getStamp()+1);
                    System.out.println(success);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int stamp=atomicStampedSimple.getStamp();
                    Thread.sleep(2000);
                    boolean success= atomicStampedSimple.compareAndSet(100,101,stamp,stamp+1);
                    System.out.println(success);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

}
