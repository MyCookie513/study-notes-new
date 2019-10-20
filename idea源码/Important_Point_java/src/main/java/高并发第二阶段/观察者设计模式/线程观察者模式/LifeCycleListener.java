package 高并发第二阶段.观察者设计模式.线程观察者模式;

public interface LifeCycleListener {
    void onEvent(ObservableRunnable.RunnableEvent event);
}
