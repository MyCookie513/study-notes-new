package 高并发第二阶段.TwoPhaseTermination第二阶段的终止设计模式;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final CounterIncrement counterIncrement=new CounterIncrement();
        counterIncrement.start();;
        Thread.sleep(1000);
        counterIncrement.close();

    }
}
