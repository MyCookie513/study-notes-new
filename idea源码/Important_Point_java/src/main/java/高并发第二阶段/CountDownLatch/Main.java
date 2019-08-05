package 高并发第二阶段.CountDownLatch;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final CountDownDIY countDownDIY=new CountDownDIY(5);
        IntStream.range(0,5).forEach(i->{
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+i+"运行完成");
                countDownDIY.countDown();
            }).start();
        });
        countDownDIY.wait0();
        System.out.println("finished notify");
    }
}
