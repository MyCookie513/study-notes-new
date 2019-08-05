package 高并发第二阶段.VolatileTest;

import java.io.InputStream;

/**
 * 如果不加  volatile 别的线程直接读取不到 此时更新到的值；
 */
public class VolatileTest {

    private  volatile static int INItVALUE =0;
    private final static  int MaxValue=5;
    //new 一个线程用来实时监控 INITVALUE 的值是否已经改变；
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            int value=INItVALUE;
            while(value<MaxValue){

                if(value!=INItVALUE) {
                    System.out.println("change INITVALUE " +
                            INItVALUE);
                    value = INItVALUE;//更新原始值；
                }
            }
        },"READER").start();
        Thread.sleep(500);
        int Init_value= INItVALUE;
        while(Init_value<MaxValue){
            INItVALUE++;
            Init_value=INItVALUE;
            System.out.println("change : " +Init_value);
            Thread.sleep(500);
        }
    }
}
