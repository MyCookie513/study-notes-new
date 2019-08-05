package 高并发第二阶段.观察者设计模式.线程观察者模式;


/**
 * 对 Runnable 接口的扩充，
 */

public abstract class ObservableRunnable implements Runnable {


    final protected  LifeCycleListener lifeCycleListener;

    public ObservableRunnable(final LifeCycleListener lifeCycleListener) {
        this.lifeCycleListener = lifeCycleListener;
    }

    //通知我的状态已经改变；
    protected void notifyChange(final RunnableEvent event){
        lifeCycleListener.onEvent(event);

    }



    /**
     * 下面 线程运行过程中，发生改变的话对这个事件的诠释；
     */
    public enum     RunnableState{
        RUNNING,ERROR,DONE
    }
    public static class  RunnableEvent{
        private final RunnableState state;
        private final Thread thread;
        private Throwable throwable;

        public RunnableEvent(RunnableState state, Thread thread, Throwable throwable) {
            this.state = state;
            this.thread = thread;
            this.throwable = throwable;
        }

        public RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getThrowable() {
            return throwable;
        }

        public void setThrowable(Throwable throwable) {
            this.throwable = throwable;
        }
    }



}
