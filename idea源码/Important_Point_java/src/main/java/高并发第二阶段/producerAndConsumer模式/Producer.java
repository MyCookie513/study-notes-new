package 高并发第二阶段.producerAndConsumer模式;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread {
    private final MessageQueue messageQueue;
    private final static Random random=new Random(System.currentTimeMillis());
    private final static AtomicInteger integer=new AtomicInteger(0);

    public Producer(MessageQueue messageQueue) {

        this.messageQueue = messageQueue;
    }


    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Message_ message_=new Message_(Thread.currentThread().getName()+"pruducer 一条信息"+integer.incrementAndGet());
                messageQueue.putMessage(message_);
                System.out.println(message_.getData());
            } catch (InterruptedException e) {

                break;
            }
        }

    }
}
