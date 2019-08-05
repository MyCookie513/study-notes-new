package 高并发第二阶段.Future设计模式的实现;

import java.util.function.Consumer;

/**
 * 作用： 结合调度任务类和 Listener 类  的  service类
 * 开启一个线程；用来处理任务，同时将Listener返回；
 */
public class FutureService {


    public <T> Future<T> submit(final FutureTask<T> futureTask){

        AsynFuture<T> asynFuture=new AsynFuture<>();
        new Thread(()->{
            T result= null;
            try {
                result = futureTask.Call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            asynFuture.done(result);
        }).start();

        return asynFuture;

    }

    public <T> Future<T> submit(final FutureTask<T> futureTask, final Consumer<T> consumer){

        AsynFuture<T> asynFuture=new AsynFuture<>();
        new Thread(()->{
            T result= null;
            try {
                result = futureTask.Call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            asynFuture.done(result);
            consumer.accept(result);
        }).start();

        return asynFuture;

    }

}
