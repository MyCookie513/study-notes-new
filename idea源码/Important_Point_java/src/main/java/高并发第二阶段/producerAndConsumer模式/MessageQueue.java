package 高并发第二阶段.producerAndConsumer模式;

import sun.plugin2.message.Message;

import java.util.LinkedList;

public class MessageQueue {
    private final LinkedList<Message_ > message_s;
    private static final int MaxLimit=100;
    private final  int limit;

    public MessageQueue() {
        this(MaxLimit);
    }

    public MessageQueue(int limit) {
        this.limit = limit;
        this.message_s =new LinkedList<>();

    }

    public void putMessage(Message_ message_) throws InterruptedException {
        synchronized (message_s){
            while (message_s.size()>limit)
                message_s.wait();
            message_s.addLast(message_);
            message_s.notifyAll();
        }

    }
    public Message_ takeMessage() throws InterruptedException {
        synchronized (message_s){
            while (message_s.isEmpty())
                message_s.wait();
            Message_ message_=message_s.removeFirst();
            message_s.notifyAll();
            return message_ ;
        }
    }

    public int getMaxLimit(){
        return this.limit;
    }
    public int getQueueSize(){
        synchronized (message_s){
            return this.message_s.size();
        }
    }
}
