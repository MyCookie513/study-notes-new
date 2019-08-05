package 高并发第一阶段.ThreadCloseGraceful;

public class interrupt中断结束 {

    public static void main(String[] args) throws InterruptedException {


        Worker0 worker=new Worker0();
        worker.start();
        Thread.sleep(2000);
        worker.interrupt();


    }



}
class Worker0 extends  Thread{

    private volatile boolean start =true;
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"  start");
        while(start){

            try{

                Thread.sleep(10);
            }catch (Exception e){
                break;
            }

        }
        System.out.println(Thread.currentThread().getName()+"  end");

    }


}