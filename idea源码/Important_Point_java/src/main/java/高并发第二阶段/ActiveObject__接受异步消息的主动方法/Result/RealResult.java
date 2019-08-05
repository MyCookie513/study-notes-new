package 高并发第二阶段.ActiveObject__接受异步消息的主动方法.Result;

public class RealResult implements Result {
    private Object resultValue;

    public RealResult(Object value) {
        this.resultValue = value;
    }

    @Override
    public Object getResultValue() {
        return this.resultValue;
    }
}
