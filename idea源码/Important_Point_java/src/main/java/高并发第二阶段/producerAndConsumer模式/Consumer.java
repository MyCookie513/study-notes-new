package 高并发第二阶段.producerAndConsumer模式;

public class Consumer extends Thread {
    private final MessageQueue messageQueue;

    public Consumer(MessageQueue messageQueue) {

        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Message_ message_=messageQueue.takeMessage();
                System.out.println("Consumer 接受到"+message_.getData());
            }catch (InterruptedException e){
                break;
            }
        }

    }
}
