package 高并发第二阶段.immutable不可变的设计模式;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

/**
 * syn:  14762
 *immutable:  11996
 */
public class Syn和Immutable的区别 {

    public static void main(String[] args) {
        String s;
        SynObj synObj=new SynObj();
        synObj.setName("Ajax");
        Immutable immutable=new Immutable("Ajax");
        long StartTime=System.currentTimeMillis();
        /*IntStream.range(0,10).forEach(i->{
            new Thread(()->{
                for (int j=0;j<100000;j++){
                    System.out.println(immutable.toString());
                }
                System.out.println("immutable:  "+ (System.currentTimeMillis()-StartTime));


            },String.valueOf(i)).start();
        });*/
        IntStream.range(0,10).forEach(i->{
            new Thread(()->{
                for (int j=0;j<100000;j++){
                    System.out.println(synObj.toString());
                }
                System.out.println("syn:  "+ (System.currentTimeMillis()-StartTime));
            },String.valueOf(i)).start();
        });
    }


}


 class SynObj{
    private  String name ;
    public synchronized void setName(String  name ){
        this.name=name ;

    }


    @Override
    public synchronized String toString() {
        return "{"+name+"}";
    }
}
final class Immutable{
    private  final String name ;

    public Immutable(String name) {
        this.name = name;
    }

    @Override
    public  String toString() {
        return "{"+name+"}";
    }
}
