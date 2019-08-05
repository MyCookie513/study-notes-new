package 高并发第二阶段.ActiveObject__接受异步消息的主动方法;

import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.异步Request.MethodRequest;

/**
 *
 *功能：
 * 1. 从请求队列中取出请求然后进行处理，调用请求内部的处理方法；
 * 2. 往请求队列中填充请求
 */
public class SchedulerThread extends Thread {
    private final MethodRequestQueue activeQueue;

    public SchedulerThread(String name,MethodRequestQueue activeQueue) {
        super(name);
        this.activeQueue = activeQueue;
    }

    public void invoke(MethodRequest methodRequest) throws InterruptedException {
        this.activeQueue.putRequest(methodRequest);

    }

    @Override
    public void run() {
        while (true){
            this.activeQueue.takeRequest().excute();
        }
    }
}
