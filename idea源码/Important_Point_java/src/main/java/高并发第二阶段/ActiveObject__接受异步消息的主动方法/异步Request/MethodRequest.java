package 高并发第二阶段.ActiveObject__接受异步消息的主动方法.异步Request;

import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.Result.FutrueResult;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject.Servant;

/**
 * 这个抽象类的引用了sevant执行的类，也就是干活的类；也也引用了FutureResult 类
 *
 * 重要的点；
 * 1.有一个异步的返回结果
 *
 */
public abstract class MethodRequest {
    protected final Servant servant;
    protected final FutrueResult futrueResult;

    protected MethodRequest(Servant servant, FutrueResult futrueResult) {
        this.servant = servant;
        this.futrueResult = futrueResult;
    }
    public abstract void excute();
}
