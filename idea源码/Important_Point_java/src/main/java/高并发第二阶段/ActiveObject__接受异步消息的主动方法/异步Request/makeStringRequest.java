package 高并发第二阶段.ActiveObject__接受异步消息的主动方法.异步Request;

import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.Result.FutrueResult;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.Result.Result;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject.Servant;

/**
 * 请求内部封装了请求方式和处理请求的方法
 */
public class makeStringRequest extends MethodRequest {
    private int count;
    private char c;

    public makeStringRequest(Servant servant, FutrueResult futrueResult, int count, char c) {
        super(servant, futrueResult);
        this.count=count;
        this.c=c;
    }

    @Override
    public void excute() {
        Result result=servant.makeString(this.count,this.c);
        futrueResult.setResult(result);
    }

}
