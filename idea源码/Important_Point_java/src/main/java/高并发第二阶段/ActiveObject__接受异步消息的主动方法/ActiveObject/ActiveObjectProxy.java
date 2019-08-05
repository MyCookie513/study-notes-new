package 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject;

import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject.ActiveObject;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject.Servant;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.SchedulerThread;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.异步Request.DisplayMethod;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.异步Request.makeStringRequest;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.Result.FutrueResult;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.Result.Result;

public class ActiveObjectProxy implements ActiveObject {
    private final Servant servant;
    private final SchedulerThread schedulerThread;

    public ActiveObjectProxy(Servant servant, SchedulerThread schedulerThread) {
        this.servant = servant;
        this.schedulerThread = schedulerThread;
    }

    /**
     * 代理类调用一个方法的时候调用一个这个方法的请求放置在RequestQueue中，返回一个异步结果
     * @param count
     * @param c
     * @return
     */
    @Override
    public Result makeString(int count, char c) {
        FutrueResult futrueResult=new FutrueResult();
        try {
            schedulerThread.invoke(new makeStringRequest(servant,futrueResult,count,c));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return futrueResult;
    }

    @Override
    public void displayString(String text) {
        try {
            schedulerThread.invoke(new DisplayMethod(servant,text));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
