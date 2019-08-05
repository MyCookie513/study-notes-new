package 高并发第一阶段.仿显式锁Lock实现;


import java.util.Collection;

public interface Lock {
    //定义一个内部异常类
  class   TimeoutException0 extends  Exception{
      public TimeoutException0(String message) {
          super(message);
      }
  }




    //在上锁的过程中允许中断
    void lock() throws InterruptedException;
    //如果在一定的时间内获取不到锁就退出来；这里可抛出中断异常，时间超出异常
    void lock(long time) throws InterruptedException,TimeoutException0;
    //释放
    void unlock();

    //返回现在有多少个线程现在被blocked 阻塞等待；
    Collection<Thread> getBlockedThread();

    int getBlockedThreadSize();


}
