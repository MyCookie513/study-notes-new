package 工具类.CyclicBarrier;
import java.util.concurrent.*;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class broken状态的转变 {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier1 = new CyclicBarrier(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
       //添加一个用await()等待的线程
        executorService.submit(() -> {
            try {
                //等待，除非：1.屏障打开;2.本线程被interrupt;3.其他等待线程被interrupted;4.其他等待线程timeout;5.其他线程调用reset()
                barrier1.await();
            } catch (InterruptedException e) {
                LOGGER.info(Thread.currentThread().getName() + " is interrupted.");
                //e.printStackTrace();
            } catch (BrokenBarrierException e) {
                LOGGER.info(Thread.currentThread().getName() + " is been broken.");
                //e.printStackTrace();
            }
        });
        Thread.sleep(10);
        LOGGER.info("刚开始，屏障是否破损：" + barrier1.isBroken());
//添加一个等待线程-并超时
        executorService.submit(() -> {
            try {
                //等待1s，除非：1.屏障打开(返回true);2.本线程被interrupt;3.本线程timeout;4.其他等待线程被interrupted;5.其他等待线程timeout;6.其他线程调用reset()
                barrier1.await(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                LOGGER.info(Thread.currentThread().getName() + " is interrupted.");
                //e.printStackTrace();
            } catch (BrokenBarrierException e) {
                LOGGER.info(Thread.currentThread().getName() + " is been reset().");
                //e.printStackTrace();
            } catch (TimeoutException e) {
                LOGGER.info(Thread.currentThread().getName() + " is timeout.");
                //e.printStackTrace();
            }
        });
        Thread.sleep(100);
        LOGGER.info("当前等待线程数量：" + barrier1.getNumberWaiting());
        Thread.sleep(1000);
        LOGGER.info("当前等待线程数量：" + barrier1.getNumberWaiting());
        LOGGER.info("当等待的线程timeout时，当前屏障是否破损：" + barrier1.isBroken());
        LOGGER.info("等待的线程中，如果有一个出现问题，则此线程会抛出相应的异常；其他线程都会抛出BrokenBarrierException异常。");

    }
}
