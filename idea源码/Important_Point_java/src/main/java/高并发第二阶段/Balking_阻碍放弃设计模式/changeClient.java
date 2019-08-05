package 高并发第二阶段.Balking_阻碍放弃设计模式;

import java.util.stream.IntStream;

public class changeClient implements Runnable {
    private final BalkingData balkingData;
    public changeClient(BalkingData balkingData) {
        this.balkingData = balkingData;
    }

    @Override
    public void run() {
        IntStream.range(0,6).forEach(i->{
            balkingData.change("号码已经被更改"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
