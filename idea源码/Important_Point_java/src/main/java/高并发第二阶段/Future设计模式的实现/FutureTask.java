package 高并发第二阶段.Future设计模式的实现;

public interface FutureTask<T> {

    T Call() throws InterruptedException;
}
