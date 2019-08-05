package 高并发第二阶段.producerAndConsumer模式;

public class Main {
    public static void main(String[] args) {
        final MessageQueue messageQueue=new MessageQueue();
        new Producer(messageQueue).start();
        new Consumer(messageQueue).start();
        new Producer(messageQueue).start();
        new Consumer(messageQueue).start();
    }
}
