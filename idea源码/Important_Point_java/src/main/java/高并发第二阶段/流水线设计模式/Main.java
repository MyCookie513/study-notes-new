package 高并发第二阶段.流水线设计模式;

import 高并发第二阶段.多线程上下文设计模式__ThreadLocal.项目应用.QueryFromDBAction;

public class Main {
    public static void main(String[] args) {

        final RequestQueue requestQueue=new RequestQueue(5);
        //工人开始上班
        requestQueue.startWork();
         new TransformThread("生产任务的线程 0  ",requestQueue).start();
       // new TransformThread("生产任务的线程 1  ",requestQueue).start();
      //  new TransformThread("生产任务的线程 2  ",requestQueue).start();

    }
}
