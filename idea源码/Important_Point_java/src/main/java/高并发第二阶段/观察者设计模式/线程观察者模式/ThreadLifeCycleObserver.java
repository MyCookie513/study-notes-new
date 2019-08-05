package 高并发第二阶段.观察者设计模式.线程观察者模式;

import java.util.List;

/***
 *总体架构：
 *
 * 1.有一个LifeCycleListener 类 ： 用来处理注册到这个监听者上面的线程的提交的状态的事件（这里还用到了接口回调）
 *
 *
 *2.核心是写了一个具备通知Listener自己状态改变的方法；
 *
 */
public class ThreadLifeCycleObserver implements LifeCycleListener {
    private final Object lock=new Object();

    /***
     * 在这里
     * @param event
     */
    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {

        synchronized (lock){
            System.out.println("我是观察者，我接收到消息："+"thr runnable ["+ event.getThread().getName()+"] data changed and state is [" +
                    event.getState()+"]");
            if(event.getThrowable()!=null){
                System.out.println("我是观察者，我接收到消息："+"thr runnable ["+ event.getThread().getName()+" run failed ");
                event.getThrowable().printStackTrace();
            }
        }


    }




}
