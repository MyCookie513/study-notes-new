package 高并发第一阶段.仿线程池简易实现;


import java.util.stream.IntStream;

/***
 *
 * 1.任务队列： 用来放置将要执行的任务；
 * 2.拒绝策略： （1）抛出异常    （2）直接丢弃   （3）阻塞    （4）将任务放到临时队列
 * 3.Init :   核心线程数；   最大线程数 ；
 */

public class Main {


    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool simpleThreadPool=new SimpleThreadPool();
        simpleThreadPool.start();
        IntStream.rangeClosed(0,20).forEach(i->{
            simpleThreadPool.submit(()->{
                System.out.println("the runnable  "+i+"   be serviced by " + Thread.currentThread()+"  start .");
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("the runnable  "+i+"   be serviced by " + Thread.currentThread()+"  finished .");

            });

        });
        simpleThreadPool.ShutDown();

        /*simpleThreadPool.submit(()->{
            System.out.println("再次提交任务");
        });*/
    }


}
