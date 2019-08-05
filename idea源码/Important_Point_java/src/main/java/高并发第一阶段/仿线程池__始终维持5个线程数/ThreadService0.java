package 高并发第一阶段.仿线程池__始终维持5个线程数;

import java.util.*;

/**
 * 实现的作用： 始终保持正在运行的线程的数量是一定的
 *
 * 这样程序运行一开始的话是所有的线程都开始在跑但是超过5个线程之后，其他的线程刚跑就被wait了
 */
public class ThreadService0 {

    final  static LinkedList<Control> CONTROLS=new LinkedList<>();
    public static void main(String[] args) {

        //定义一个容器来保存这些线程；
        List<Thread> worker=new ArrayList<>();
        //循环利用创建线程方法来不断创建线程
        Arrays.asList("M1","M2","M3","M4","M5","M6","M7","M8").stream().map(ThreadService0::CreateThread).forEach(
                t->{
                    t.start();
                    worker.add(t);
                }
        );

        //把所有的start的线程join到这个位置
        worker.stream().forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //如果那个Object 不为空则将进行那种操作
        Optional.of("all threads had finished .").ifPresent(System.out::println);

    }


    public  static Thread  CreateThread(String name ){
        return new Thread(()->{

            //用来控制线程的数量，如果线程的数量过多的话线程的将 wait ；
            synchronized (CONTROLS){
                while (CONTROLS.size()>5){
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                CONTROLS.addLast(new Control());
            }

            System.out.println(Thread.currentThread().getName()+"  running !");
            //线程正在进行工作
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //线程在工作完之后要修改共享资源也就是CONTROLS ，我已经工作完了，已经替出一个空位来了
            synchronized (CONTROLS){
                System.out.println(Thread.currentThread().getName()+"  END  !");
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }



        },name);
    }


    //定义一个内部类
    static  class  Control {

    }





}
