package 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject;

import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.Result.Result;

public interface ActiveObject {

    Result makeString (int count , char c);

    void displayString(String  text);
}
