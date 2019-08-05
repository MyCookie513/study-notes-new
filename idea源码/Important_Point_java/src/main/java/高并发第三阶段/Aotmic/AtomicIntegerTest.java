package 高并发第三阶段.Aotmic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {


    public static void main(String[] args) {
        AtomicInteger i=new AtomicInteger();
        System.out.println(i.get());
        i=new AtomicInteger(10);
        System.out.println(i.get());
        i.set(12);
        System.out.println(i.get());
        i.lazySet(23);
        System.out.println(i.get());



        //get and set
        int a=i.getAndSet(12);
        System.out.println("get:  "+a+ "  set:  " + i.get());
        // get and add  同样的道理

    }

}
