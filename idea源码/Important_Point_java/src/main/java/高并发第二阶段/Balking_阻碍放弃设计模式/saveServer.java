package 高并发第二阶段.Balking_阻碍放弃设计模式;

public class saveServer implements Runnable {
    private final BalkingData balkingData;

    public saveServer(BalkingData balkingData) {
        this.balkingData = balkingData;
    }

    @Override
    public void run() {
        while (true)
        balkingData.save();
    }
}
