package 高并发第一阶段.仿线程池简易实现;

import java.util.*;

/***
 *
 * 1.任务队列： 用来放置将要执行的任务；
 * 2.拒绝策略： （1）抛出异常    （2）直接丢弃   （3）阻塞    （4）将任务放到临时队列
 * 3.Init :   核心线程数；   最大线程数 ；
 */
public class SimpleThreadPool extends Thread{
    //初始化线程池的大小：
    private  final  int min_Size ;
    private  final  int max_Size ;
    private  final  int acitve_Size ;
    private  final  int QueueSize ;
    private volatile boolean destory;
    private static  int DEFAULT_QUEUE_SIZE=200;
    private static  volatile int active_thread=0;
    //  创建一个任务队列
    private static final LinkedList<Runnable> TASK_QUEUE=new LinkedList<>();

    private static  volatile int seq=0;  //线程的长度；
    private  final static  String THREAD_PROFIX ="SIMPLE_THEAD_POOL";//设置线程池的名字
    private final static ThreadGroup GROUP=new ThreadGroup("pool");//为线程池创建一个依赖的线程组
    private final static Vector<TaskThread>  QUEUE_THREAD=new Vector<>();
    private final  DiscartPolicy discartPolicy;
    public SimpleThreadPool(int min_Size,int max_Size,int acitve_Size, int queueSize ,DiscartPolicy discartPolicy) {
        this.min_Size=min_Size;
        this.acitve_Size=acitve_Size;
        this.max_Size=max_Size;
        this.QueueSize = queueSize;
        this.discartPolicy=discartPolicy;

        Init();
    }

    @Override
    public void run() {
        while(!destory){
            System.out.println("min: "+this.min_Size+"\nmax: "+max_Size+"\ncurrent: "+ QUEUE_THREAD.size()+"\nTaskQueue： "+TASK_QUEUE.size());

            if(TASK_QUEUE.size()>acitve_Size &&  QUEUE_THREAD.size()<max_Size){
                CreateTaskThread();
                active_thread++;
            }


            System.out.println(active_thread);
            if(TASK_QUEUE.isEmpty()&&active_thread<=min_Size&& QUEUE_THREAD.size()>min_Size){
                synchronized (QUEUE_THREAD){

                        //在一个list中边遍历，边增删改操作；
                        for(Iterator<TaskThread> it=QUEUE_THREAD.iterator(); it.hasNext();){
                            TaskThread taskThread=it.next();
                            if(taskThread.taskState==TaskState.BLOCKED && active_thread<=min_Size&& QUEUE_THREAD.size()>min_Size){
                                taskThread.interrupt();
                                taskThread.close();
                                it.remove();
                            }
                        }


                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public SimpleThreadPool() {
        this(5,15,10, DEFAULT_QUEUE_SIZE,()->{
            throw new DiscardExeception("任务队列溢出");
        });
    }

    //在初始化的过程中就要创建一些核心线程数
    private void Init() {
        for(int i=0;i<min_Size;i++){
            CreateTaskThread();
            active_thread++;
        }

    }
    public void CreateTaskThread(){
        TaskThread taskThread=new TaskThread(GROUP,THREAD_PROFIX+(seq++));
        taskThread.start();
        QUEUE_THREAD.add(taskThread);
    }

    //开启对外的接口；
    public void submit(Runnable runnable){
        if(destory)
            throw   new  IllegalStateException("线程池已经关闭，不能再提交任务");
        if(!destory){
            synchronized (TASK_QUEUE){
                if(TASK_QUEUE.size()>QueueSize)
                    discartPolicy.discard();
                TASK_QUEUE.addLast(runnable);
                TASK_QUEUE.notifyAll();

            }
        }

    }


    //创建一个枚举类型来表示任务的状态；
    private  enum  TaskState{
        FREE,RUNNING,BLOCKED,DEAD  //分别代表 空闲，运行 ，阻塞，挂掉
    }

    /**
     * 线程池中的线程具有的特点
     * 1.只要任务队列中有任务就永不停止的去运转任务不然就wait；
     * 2.线程如果被打断的终止运行
     */
    private static class TaskThread extends Thread{
        //此时这个任务线程的状态
        private volatile TaskState taskState=TaskState.FREE;


        public TaskThread(ThreadGroup group, String name) {
            super(group, name);
        }

        public TaskState getTaskState() {
            return taskState;
        }

        @Override
        public void run() {
            Runnable runnable;
            OUTER:
            while (this.taskState!= TaskState.DEAD){ //如果线程没有被设定运行结束；不断尝试去运行任务
                synchronized (TASK_QUEUE){

                    while (TASK_QUEUE.isEmpty()){
                        try {
                            taskState=TaskState.BLOCKED;
                            active_thread--;
                            TASK_QUEUE.wait();
                            active_thread++;
                        } catch (InterruptedException e) {

                            break OUTER;
                        }

                    }
                    runnable=TASK_QUEUE.removeFirst();

                }

                    taskState=TaskState.RUNNING;
                    runnable.run();
                    taskState=TaskState.FREE;





            }
            synchronized (QUEUE_THREAD){
                QUEUE_THREAD.remove(this);
            }
        }
        public void close(){
            this.taskState=TaskState.DEAD;
        }
    }



    //用来实现任务拒绝策略的功能


    public static class DiscardExeception extends RuntimeException{

        public DiscardExeception(String message) {
            super(message);
        }
    }

    public interface  DiscartPolicy{
        void discard() throws DiscardExeception;
    }



    //在等待任务完成后关闭线程池
    public void ShutDown() throws InterruptedException {


        while(!TASK_QUEUE.isEmpty()){
            Thread.sleep(50);
        }
        synchronized (QUEUE_THREAD) {
            int initVal = QUEUE_THREAD.size();
            while (initVal != 0) {
                for (TaskThread t : QUEUE_THREAD) {
                    if (t.taskState == TaskState.BLOCKED) {
                        t.interrupt();
                        t.close();
                        initVal--;
                    } else {
                        Thread.sleep(10);
                        //System.out.println("有线程不在阻塞状态");
                    }

                }
            }

            this.destory = true;
            System.out.println(initVal);
        }
        System.out.println("Pool is destoryed .");
    }

}
