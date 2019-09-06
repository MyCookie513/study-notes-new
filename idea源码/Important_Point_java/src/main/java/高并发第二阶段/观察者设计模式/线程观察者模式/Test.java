package 高并发第二阶段.观察者设计模式.线程观察者模式;

import java.util.Arrays;
import java.util.List;
/***
 *总体架构：
 *
 * 1.有一个LifeCycleListener 类 ： 用来处理注册到这个监听者上面的线程的提交的状态的事件（这里还用到了接口回调）
 *
 *
 *2.核心是写了一个具备通知Listener自己状态改变的方法；
 *
 * 不是被动的被观察是否线程运行的状态改变；
 * 而是自己的状态改变后告诉注册中心自己的状态被改变了；
 */
public class Test {


    public static void main(String[] args) {
        CreateThreadRegister(Arrays.asList("1", "2", "3"), new ThreadLifeCycleObserver());

    }

    public static void CreateThreadRegister(List<String> ids, LifeCycleListener lifeCycleListener) {

        if (ids == null || ids.isEmpty())
            return;
        ids.stream().forEach(id -> new Thread(new ObservableRunnable(lifeCycleListener) {
            @Override
            public void run() {
                try {
                    //调用抽象类中的方法；
                    notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                    System.out.println("query for the id" + id);
                    Thread.sleep(1000);
                    notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));

                } catch (Exception e) {
                    notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
                }
            }
        }).start());
    }
}