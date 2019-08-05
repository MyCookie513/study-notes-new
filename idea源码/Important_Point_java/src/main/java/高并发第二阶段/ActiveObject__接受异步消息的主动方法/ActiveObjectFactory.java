package 高并发第二阶段.ActiveObject__接受异步消息的主动方法;

import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject.ActiveObject;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject.ActiveObjectProxy;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject.Servant;

/**
 * 这类不能被继承同时不能被new
 */
public final class ActiveObjectFactory {

    private ActiveObjectFactory(){

    }

    public static ActiveObject createActiveObject(){
            Servant servant=new Servant();
            MethodRequestQueue queue=new MethodRequestQueue();
            SchedulerThread schedulerThread=new SchedulerThread("Scheduler",queue);
            ActiveObjectProxy activeObjectProxy=new ActiveObjectProxy(servant,schedulerThread);
            schedulerThread.start();
            return activeObjectProxy;
    }
}
