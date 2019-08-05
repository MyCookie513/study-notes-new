package JUC_concurrency_原子性;


import java.util.concurrent.atomic.AtomicInteger;

class AtomicDemo  implements Runnable {

    private AtomicInteger serialNumber = new AtomicInteger(0);

    public int getSerialNumber() {
        return serialNumber.getAndIncrement();
    }

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getSerialNumber());
    }

}

public class Atomic_原子作用 {

    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();

        for(int i=0;i<10;i++)
            new Thread(ad).start();

    }

}





