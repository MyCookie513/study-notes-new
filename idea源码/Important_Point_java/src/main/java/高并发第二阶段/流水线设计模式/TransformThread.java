package 高并发第二阶段.流水线设计模式;

import java.util.Random;

/**
 * 主要负责在   任务队列中   放置任务
 */
public class TransformThread extends Thread {
    private final RequestQueue requestQueue;
    //创建一个随机数
    private final static  Random random=new Random(System.currentTimeMillis());

    public TransformThread(String name,RequestQueue requestQueue) {
        super(name );
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i=0;true;i++){
            Request request=new Request(getName(),i);
            try {
                this.requestQueue.put(request);
                Thread.sleep(random.nextInt(1_000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
