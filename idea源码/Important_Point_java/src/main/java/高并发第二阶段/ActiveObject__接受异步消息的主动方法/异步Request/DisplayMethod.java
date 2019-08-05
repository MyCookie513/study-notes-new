package 高并发第二阶段.ActiveObject__接受异步消息的主动方法.异步Request;

import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject.Servant;



public class DisplayMethod extends MethodRequest {
    private String text;
    public DisplayMethod(Servant servant,String text) {
        super(servant, null);
        this.text=text;
    }

    @Override
    public void excute() {
        servant.displayString(text);
    }
}
