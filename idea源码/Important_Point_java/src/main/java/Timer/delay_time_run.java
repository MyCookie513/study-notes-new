package Timer;

import java.util.Timer;

public class delay_time_run {

    public static void main(String[] args) {
        System.out.println("start:3秒后执行" );
        Timer timer=new Timer();
        timer.schedule(new Task(timer),3000,1000);
       // timer.cancel();

    }
}
