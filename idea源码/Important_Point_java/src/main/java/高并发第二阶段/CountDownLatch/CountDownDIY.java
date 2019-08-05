package 高并发第二阶段.CountDownLatch;

public class CountDownDIY {
    private final int total;
    private int count=0;

    public CountDownDIY(int total) {
        this.total = total;
    }
    public void countDown(){
        synchronized (this){
            count++;
            if (count>=total)
                this.notify();

        }
    }

    public void wait0() throws InterruptedException {
        synchronized (this){
            if(count>=total)
                return;
            else
                this.wait();
            }
    }

}
