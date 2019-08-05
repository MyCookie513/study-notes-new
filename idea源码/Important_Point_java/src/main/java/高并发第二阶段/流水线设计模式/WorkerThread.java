package 高并发第二阶段.流水线设计模式;

/**
 * 从工作队列中获取request，然后处理请求
 */
public class WorkerThread extends Thread {

    private RequestQueue requestQueue;
    public WorkerThread(String s, RequestQueue requestQueue) {
        super(s);
        this.requestQueue=requestQueue;
    }

    @Override
    public void run() {
        while(true){
            try {
                this.requestQueue.take().excute();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
