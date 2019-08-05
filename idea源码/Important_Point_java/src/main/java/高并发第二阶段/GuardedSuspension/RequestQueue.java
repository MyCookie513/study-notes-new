package 高并发第二阶段.GuardedSuspension;

import java.util.LinkedList;

public class RequestQueue {

    private final LinkedList<Request> queueRequest=new LinkedList<Request>();


    public  Request getRequest()  {
        synchronized (queueRequest){
                    while (queueRequest.size()<=0){
                        try {
                            queueRequest.wait();
                        } catch (InterruptedException e) {
                            return null;
                        }
            }
            return queueRequest.removeFirst();
        }
    }

    public void putRequest(Request request) {
        synchronized (queueRequest){
           queueRequest.addLast(request);
           queueRequest.notifyAll();
        }
    }


}
