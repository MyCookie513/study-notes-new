package 高并发第二阶段.Future设计模式的实现;

/**
 *
 * 目前是两种设计模式
 * 1. 正常的future获取模式
 * 2.  任务处理结果出来后，自动进行调用一些代码
 *
 *
 * 运行过程： 提交一个任务，分给一个线程去调用这个任务，这个线程在处理完它的任务后，会把它的最终的结果，放到future中；
 * future在result没有出现之前如果有线程来索取result，这样的话这个线程就会陷入等待；
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {
        FutureService futureService=new FutureService();
        Future<String> future= futureService.submit(new FutureTask<String>() {
           @Override
           public String Call() throws InterruptedException {

               Thread.sleep(3000);
               return "RESULT ";
           }
        },System.out::println);

       /* System.out.println(" 我正在做其他的事情；" );
        System.out.println("得到任务处理后的结果为： " + future.get());*/

    }
}
