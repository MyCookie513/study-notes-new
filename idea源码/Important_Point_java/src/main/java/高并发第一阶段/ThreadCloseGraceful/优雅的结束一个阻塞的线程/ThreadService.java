package 高并发第一阶段.ThreadCloseGraceful.优雅的结束一个阻塞的线程;


/**
 * 利用daemon 守护线程 随夫线程一起陨落的原理   来相对优雅的结束一个正在阻塞的线程；
 */

public class ThreadService {

    //调用的夫君线程
    private  Thread Husband_Thread ;
    //设置一个任务是否完成的标志
    volatile boolean finished = false ;

    public void execute (Runnable task){
        Husband_Thread=new Thread(new Runnable() {
            @Override
            public void run() {
                //设置老婆线程 ；
                Thread Task=new Thread(task);
                Task.setDaemon(true);
                Task.start();
                System.out.println("任务开始执行");
                try {
                    Task.join();//join sleep wait  all can Be interrupted.
                    finished=true;
                    System.out.println("任务执行完成");
                } catch (InterruptedException e) {
                    System.out.println("task 任务 被 中断执行" );
                }


            }
        });
        Husband_Thread.start();
    }


    /**
     * 如果延时delayTime时间后，不管任务有没有完成都将任务进行强制的关闭
     * 如果是任务提前完成则自动退出
     * @param delayTime
     */
    public void shutDown(long delayTime){
        long startTime=System.currentTimeMillis();

        while ((System.currentTimeMillis()-startTime)<=delayTime){
            if(finished==true){
                finished=false;
                return;
            }

        }

        Husband_Thread.interrupt();
    }


}
