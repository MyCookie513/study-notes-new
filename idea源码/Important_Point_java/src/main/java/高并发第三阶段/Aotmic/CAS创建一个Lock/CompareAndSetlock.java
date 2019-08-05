package 高并发第三阶段.Aotmic.CAS创建一个Lock;

import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSetlock {

    private  Thread currentThread =null;

    private final AtomicInteger lockState =new AtomicInteger(0);

    public void tryLock()  throws  GetLockException{
        boolean success =lockState.compareAndSet(0,1);
        if(!success)
            throw new GetLockException(" get Lock is failed ; ");
        else {
            System.out.println(Thread.currentThread().getName() + " get lock success ");
            currentThread=Thread.currentThread();
        }
    }


    public void unLock(){
        if(currentThread==Thread.currentThread() && 1==lockState.get()){
            lockState.compareAndSet(1,0);
            System.out.println(Thread.currentThread().getName()+" 解锁成功；");
        }
    }
}
