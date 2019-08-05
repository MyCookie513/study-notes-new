package 高并发第一阶段.仿显式锁Lock实现;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BooleanLock implements Lock {

    //false代表这个锁是空闲的的
    //true代表这个锁已经被获得
    private  boolean initValue;

    private Thread  currentThread ;
    private Collection<Thread> BlockedThreadCollection=new ArrayList<>();
    public BooleanLock() {
        this.initValue = false;
    }

    @Override
    public synchronized  void lock() throws InterruptedException {
        while (initValue){
            this.wait();//此线程需要退出等待
            BlockedThreadCollection.add(Thread.currentThread());
        }
        BlockedThreadCollection.remove(Thread.currentThread());
        initValue=true;
        currentThread=Thread.currentThread();
    }

    @Override
    public synchronized void lock(long time) throws InterruptedException, TimeoutException0 {
        if(time<0)
            throw new TimeoutException0("Time out");
        long  hasRemaining =time; //代表还能保持多少时间
        long endTime= System.currentTimeMillis()+hasRemaining;
        while(initValue){
            if(hasRemaining<0)
                throw new TimeoutException0("Time out");
            BlockedThreadCollection.add(Thread.currentThread());
            this.wait(hasRemaining);
            hasRemaining=endTime-System.currentTimeMillis();

        }

        this.initValue=true;
        BlockedThreadCollection.remove(Thread.currentThread());
        this.currentThread=Thread.currentThread();
    }

    @Override
    public synchronized void unlock() {

        if(currentThread==Thread.currentThread()){
            initValue=false;
            System.out.println(Thread.currentThread().getName()+ "释放了 Boolean Lock 。");
            this.notifyAll();
        }

    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(BlockedThreadCollection);
    }

    @Override
    public  int getBlockedThreadSize() {
        return BlockedThreadCollection.size();
    }
}
