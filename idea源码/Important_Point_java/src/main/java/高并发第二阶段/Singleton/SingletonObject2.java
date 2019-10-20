package 高并发第二阶段.Singleton;

public class SingletonObject2 {

    private SingletonObject2 instance;
    private SingletonObject2() {

    }
    /**
     * double check的算法
     *
     * First check ： 简单 的创建一下是否创建了单例
     * Second check ： 是要锁住创建实例的过程
     *
     * 如果即实现了lazy load
     * 又解决了Synchronized的导致效率降低的问题
     * 这样只有开始的时候就进入了同步块；
     * 其他的时候直接不用进入同步块；
     *
     *
     *
     * 但是会出现一个问题： 就是返回instance的过程中，这个instance并没有初始化完成，
     * 但在这个时候，别的线程可能已经在使用这个instance；
     * @return
     */
    private SingletonObject2 getInstance(){
        if(instance==null){
            synchronized (SingletonObject2.class){
                if(instance==null){
                    instance= new SingletonObject2();
                }
            }

        }
        return instance;
    }
}
