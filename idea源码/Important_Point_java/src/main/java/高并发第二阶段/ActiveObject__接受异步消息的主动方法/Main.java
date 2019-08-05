package 高并发第二阶段.ActiveObject__接受异步消息的主动方法;

import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject.ActiveObject;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.Client.makeStringClientThread;

public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject=ActiveObjectFactory.createActiveObject();


        new makeStringClientThread("Alice",activeObject).start();
        //new makeStringClientThread("Bob",activeObject).start();


        //new DisplayClientThread("Tom",activeObject).start();

    }
}
