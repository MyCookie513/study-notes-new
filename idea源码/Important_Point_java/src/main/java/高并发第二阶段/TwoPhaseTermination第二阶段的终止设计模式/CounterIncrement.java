package 高并发第二阶段.TwoPhaseTermination第二阶段的终止设计模式;

public class CounterIncrement extends Thread {
    private volatile  boolean termination=false;
    private int counter =0;

    @Override
    public void run() {

        try{
            while (!termination){
                System.out.println(Thread.currentThread().getName()+counter);
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {

        } finally {
            clean();
        }
    }

    private void clean() {
        System.out.println("do something for clean work two phase  ");
    }

    public void close(){
        this.termination=false;
        this.interrupt();

    }
}
