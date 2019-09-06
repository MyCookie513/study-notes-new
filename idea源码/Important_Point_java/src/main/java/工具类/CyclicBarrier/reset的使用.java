package 工具类.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class reset的使用 {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier2 = new CyclicBarrier(2);
        //如果是一个初始的CyclicBarrier，则reset()之后，什么也不会发生
        LOGGER.info("如果是一个初始的CyclicBarrier，则reset()之后，什么也不会发生");
        barrier2.reset();
        System.out.println();

        Thread.sleep(100);
        //如果是一个已经打开一次的CyclicBarrier，则reset()之后，什么也不会发生
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        //等待两次
        for (int i = 0; i < 2; i++) {
            executorService2.submit(() -> {
                try {
                    barrier2.await();
                    LOGGER.info("222屏障已经打开.");
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    LOGGER.info("222被中断");
                } catch (BrokenBarrierException e) {
                    //e.printStackTrace();
                    LOGGER.info("222被重置");
                }
            });
        }
        barrier2.reset();

        Thread.sleep(100);
        System.out.println();
        //如果是一个 有线程正在等待的线程，则reset()方法会使正在等待的线程抛出异常
        executorService2.submit(() -> {
            executorService2.submit(() -> {
                try {
                    barrier2.await();
                    LOGGER.info("333屏障已经打开.");
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    LOGGER.info("333被中断");
                } catch (BrokenBarrierException e) {
                    LOGGER.info("在等待过程中，执行reset()方法，等待的线程抛出BrokenBarrierException异常，并不再等待");
                    //e.printStackTrace();
                }
            });
        });
        Thread.sleep(100);
        barrier2.reset();
        executorService2.shutdown();


    }
}
