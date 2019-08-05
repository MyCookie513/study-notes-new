package 高并发第二阶段.GuardedSuspension;

import java.util.Random;

public class ServerThread extends  Thread {

    private final RequestQueue requestQueue;
    private  final Random random;
    private volatile boolean flag=true;

    public ServerThread(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
        this.random =new Random(System.currentTimeMillis());

    }

    @Override
    public void run() {

        while (flag){
            Request request=  requestQueue.getRequest();
            if(request==null)
                continue;
            System.out.println("Server-> :"+request.getValue());


            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
    public void Close(){
        this.flag=false;
        this.interrupt();
    }
}
