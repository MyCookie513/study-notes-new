package Timer;

import java.util.Timer;
import java.util.TimerTask;

public class Task extends TimerTask {
    Timer timer;
    public Task(Timer timer) {
        this.timer=timer;
    }

    @Override
    public void run() {
        System.out.println("开始执行任务");
        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行任务结束");
        timer.cancel();
    }
}
