package 高并发第二阶段.Future设计模式的实现;


/**
 * 作用： 监视并获取任务处理的结果；
 * 如果任务还没有处理完成；则这个需要结果的线程继续等待；、
 * 如果任务完成直接取走结果
 * @param <T>
 */
public class AsynFuture<T> implements Future<T> {


    private volatile  boolean isFinished=false;
    private T result;

    public void done(T result){
        synchronized (this){
            this.result=result;
            this.isFinished=true;
            this.notifyAll();
        }
    }

    @Override
    public T get() throws InterruptedException {
        synchronized (this){
            while (!isFinished){
                this.wait();
            }
        }
        return result;
    }
}
