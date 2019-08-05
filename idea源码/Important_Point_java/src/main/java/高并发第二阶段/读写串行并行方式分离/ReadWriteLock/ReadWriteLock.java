package 高并发第二阶段.读写串行并行方式分离.ReadWriteLock;

public class ReadWriteLock {
    //正在进行读的线程有几个
    private int readingReaders=0;
    //正在等待想读的阅读线程
    private int WaitingReaders=0;
    private int writingWriters=0;
    private int WaitingWriters=0;
    private boolean preferWrite=true;


    public synchronized void readLock() throws InterruptedException {
        this.WaitingReaders++;
        try{
            while(writingWriters>0||(preferWrite==true&&WaitingWriters>0)){
                this.wait();
            }
        }finally {
            this.readingReaders++;
            this.WaitingReaders--;
        }
    }

    public synchronized void readOnLock(){
                this.readingReaders--;
                notifyAll();
    }


    public synchronized void writeLock() throws InterruptedException {
        this.WaitingWriters++;
        try{
            while(writingWriters>0||readingReaders>0){
                this.wait();
            }
        }finally {
            this.writingWriters++;
            this.WaitingWriters--;
        }
    }
    public synchronized void writeOnLock(){
        this.writingWriters--;
        notifyAll();
    }



}
