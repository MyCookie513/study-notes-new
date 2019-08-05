package 高并发第二阶段.ActiveObject__接受异步消息的主动方法.Client;

import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject.ActiveObject;

public class DisplayClientThread extends Thread {
    private final ActiveObject activeObject;

    public DisplayClientThread(String name,ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        for (int i=0;true;i++){
            String text=Thread.currentThread().getName()+"=>"+i;
            activeObject.displayString(text);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
