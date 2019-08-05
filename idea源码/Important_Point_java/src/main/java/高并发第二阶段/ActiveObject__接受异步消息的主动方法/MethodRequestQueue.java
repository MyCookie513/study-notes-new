package 高并发第二阶段.ActiveObject__接受异步消息的主动方法;

import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.异步Request.MethodRequest;

import java.util.LinkedList;

/**
 * 放置方法请求的一个队列
 */
public class MethodRequestQueue {
    private final static int MaxSize=100;
    private final LinkedList<MethodRequest> requestQueue=new LinkedList<>();

    public synchronized void putRequest(MethodRequest methodRequest) throws InterruptedException {
        while (requestQueue.size()>=MaxSize){
            this.wait();
        }
        requestQueue.addLast(methodRequest);
        this.notifyAll();
    }
    public synchronized MethodRequest takeRequest(){
        while (requestQueue.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MethodRequest methodRequest=requestQueue.removeFirst();
        this.notifyAll();
        return methodRequest;
    }
}
