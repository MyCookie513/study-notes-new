package 高并发第二阶段.读写串行并行方式分离.ReadWriteLock;

public class Main {


    public static void main(String[] args) {
        char[] a="asdfghjkl".toCharArray();
        final SharedData sharedData=new SharedData(a);
        new ReadWork(sharedData).start();
        new ReadWork(sharedData).start();
        new ReadWork(sharedData).start();
        new ReadWork(sharedData).start();
        new ReadWork(sharedData).start();
        new ReadWork(sharedData).start();
        new ReadWork(sharedData).start();
        new ReadWork(sharedData).start();
        new ReadWork(sharedData).start();
        new WriteWork(sharedData, "zxcvbnm").start();
        new WriteWork(sharedData, "qwertyuiop").start();
        new WriteWork(sharedData, "asdfghjkl").start();


    }

}
