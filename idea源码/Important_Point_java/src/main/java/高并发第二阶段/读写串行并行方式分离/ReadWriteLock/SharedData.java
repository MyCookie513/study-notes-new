package 高并发第二阶段.读写串行并行方式分离.ReadWriteLock;

public class SharedData {

    private final char[] data;
    private final ReadWriteLock lock=new ReadWriteLock();

    public SharedData(char[] data) {
        this.data = data;
    }

    public  char[] read() throws InterruptedException {
        try{
            lock.readLock();
            return doRead();
        }finally {
            lock.readOnLock();
        }
    }

    private char[] doRead() throws InterruptedException {
        char[] newBuf=new char[data.length];
        for(int i=0;i<data.length;i++){
            newBuf[i]=data[i];
        }
        Thread.sleep(50);
        return newBuf;
    }
    public  void write(char c) throws InterruptedException {
        try{
            lock.writeLock();
             doWrite(c);
        }finally {
            lock.writeOnLock();
        }
    }

    private void doWrite(char c) {
        for(int i=0;i<data.length;i++){
            data[i]=c;
        }
    }

}
