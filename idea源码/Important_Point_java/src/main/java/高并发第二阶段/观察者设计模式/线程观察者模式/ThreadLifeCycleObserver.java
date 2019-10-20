package 高并发第二阶段.观察者设计模式.线程观察者模式;

import java.util.List;

//todo 事件通知中心处   ：   事件通知提交的过程是线程安全的（阻塞的）；

public class ThreadLifeCycleObserver implements LifeCycleListener {
    private final Object lock=new Object();

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (lock){
            System.out.println("我是观察者中心，我接收到消息："+"thr runnable ["+ event.getThread().getName()+"] data changed and state is [" +
                    event.getState()+"]");
            if(event.getThrowable()!=null){
                System.out.println("我是观察者中心，我接收到消息："+"thr runnable ["+ event.getThread().getName()+" run failed ");
                event.getThrowable().printStackTrace();
            }
        }
    }

}
