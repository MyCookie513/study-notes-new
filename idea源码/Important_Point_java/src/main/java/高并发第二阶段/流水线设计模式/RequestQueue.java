package 高并发第二阶段.流水线设计模式;

import java.util.Arrays;

/**
 * 这种设计模式   :    任务的流水线（长度一定的队列式运转任务空间）+类似于线程池似的工人处理
 * 这个队列是一个比较好的队列的算法实现
 * 1.形成一个比较好的队列，队列的长度是一定的
 * 2.创建一个工人流水线，并具有启动他们的功能；
 * 这个流水线并不是一个任务n个线程依次轮流执行；
 *
 */
public class RequestQueue {
    private final static int MaxSize=100;
    private final Request[] requests;
    private int head=0;
    private int tail=0;
    private int count=0;
    private WorkerThread[] workerThreads;

    public RequestQueue(int worker_number) {
        this.workerThreads=new WorkerThread[worker_number];
        this.requests=new Request[MaxSize];
        this.Init();
    }

    private void Init() {
        for (int i=0;i<workerThreads.length;i++){
            workerThreads[i]=new WorkerThread("whorker :"+i,this);
        }
    }

    //将所有的线程都启动起来，开始处理任务
    public void  startWork(){
        Arrays.asList(workerThreads).forEach(WorkerThread::start);
    }

    public synchronized Request take() throws InterruptedException {
        while(count==0){
            this.wait();
        }
        Request request=this.requests[head];
        this.head=(this.head+1)%this.requests.length;
        this.count--;
        this.notifyAll();
        return request;
    }

    public synchronized void  put(Request request) throws InterruptedException {
        while (count==requests.length){
            this.wait();
        }
        this.requests[tail]=request;
        this.tail=(this.tail+1)%requests.length;
        this.count++;
        this.notifyAll();
    }
}
