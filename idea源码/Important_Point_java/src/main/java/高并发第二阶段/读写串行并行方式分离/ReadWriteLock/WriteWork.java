package 高并发第二阶段.读写串行并行方式分离.ReadWriteLock;

import java.util.Random;

public class WriteWork extends  Thread {
    private static final Random random=new Random(System.currentTimeMillis());
    private final SharedData sharedData;
    private final String filter;
    private int index=0;

    public WriteWork(SharedData sharedData, String filter) {
        this.sharedData = sharedData;
        this.filter = filter;
    }


    @Override
    public void run() {
        try {
            while(true){
                char c=nextChar();
                sharedData.write(c);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private char nextChar(){
        char c=filter.charAt(index);
        index++;
        if (index>=filter.length())
            index=0;
        return c;

    }
}

