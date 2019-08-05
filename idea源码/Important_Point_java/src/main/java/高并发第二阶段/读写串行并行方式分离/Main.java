package 高并发第二阶段.读写串行并行方式分离;

/**
 * 这样的设计模式会导致无论读还是写都是加锁串行话的执行，
 * 然而最高的效率是只有读的操作的时候可以是并行话的
 */
public class Main {

    public static void main(String[] args) {
        Gate gate=new Gate();
        User bj=new User("BeiLao","Beijing",gate);
        User gz=new User("GuangLao","Guangzhou",gate);
        User sh=new User("shanghairen ","shanghai",gate);
        bj.start();
        gz.start();
        sh.start();
    }
}
