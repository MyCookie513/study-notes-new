package 高并发第二阶段.读写串行并行方式分离.ReadWriteLock;

public class ReadWork extends Thread {


    private final SharedData sharedData;
    private int index=0;

    public ReadWork(SharedData sharedData) {
        this.sharedData = sharedData;
    }


    @Override
    public void run() {
        try {
            while(true){
                System.out.println(Thread.currentThread().getName()+"   reads  " +String.valueOf(sharedData.read())) ;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
