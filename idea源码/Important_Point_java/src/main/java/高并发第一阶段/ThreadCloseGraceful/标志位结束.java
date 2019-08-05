package 高并发第一阶段.ThreadCloseGraceful;

public class 标志位结束 {

    public static void main(String[] args) throws InterruptedException {
        Worker worker=new Worker();
        worker.start();
        Thread.sleep(2000);
        worker.Shutdown();

    }


}
class Worker extends  Thread{

    private volatile boolean start =true;
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"  start");
        while(start){


        }
        System.out.println(Thread.currentThread().getName()+"  end");

    }

    public  void Shutdown(){
        start=false;
    }

}