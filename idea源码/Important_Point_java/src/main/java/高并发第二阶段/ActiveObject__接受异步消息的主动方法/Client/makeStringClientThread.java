package 高并发第二阶段.ActiveObject__接受异步消息的主动方法.Client;

import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject.ActiveObject;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.Result.Result;

/**
 * 不断发出异步请求
 *
 */
public class makeStringClientThread extends Thread {
    private final ActiveObject activeObject;
    private final char fillChar;

    public makeStringClientThread(String name,ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
        fillChar=name.charAt(0);
    }

    @Override
    public void run() {
        for(int i=0;true;i++){
            Result result=activeObject.makeString(i+1,fillChar);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String value= (String) result.getResultValue();
            System.out.println(Thread.currentThread().getName()+": value->"+value);
        }
    }
}
