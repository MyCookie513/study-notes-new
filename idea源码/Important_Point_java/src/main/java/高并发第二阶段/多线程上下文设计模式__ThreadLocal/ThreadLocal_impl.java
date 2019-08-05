package 高并发第二阶段.多线程上下文设计模式__ThreadLocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocal_impl<T> {

    private final Map<Thread,T> map=new HashMap<>();
    public  synchronized void put(T obj){
        map.put(Thread.currentThread(),obj);
    }
    public synchronized T get(){
        return map.get(Thread.currentThread());
    }
}
