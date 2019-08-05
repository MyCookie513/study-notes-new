package �̳߳�;

//�޸���JavaԴ�벿�֣�
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) { 
    	
 
      // ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 8, 200, TimeUnit.MILLISECONDS,
        //       new ArrayBlockingQueue<Runnable>(5),new ThreadPoolExecutor.DiscardPolicy());
        ExecutorService executor=Executors.newCachedThreadPool();
      
        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
           // executor0.execute(myTask);
            System.out.println("�̳߳����߳���Ŀ��"+((ThreadPoolExecutor) executor).getPoolSize()+"�������еȴ�ִ�е�������Ŀ��"+
            ((ThreadPoolExecutor) executor).getQueue().size()+"����ִ������������Ŀ��"+((ThreadPoolExecutor) executor).getCompletedTaskCount());
        }
        executor.shutdown();
    }
}


class MyTask implements Runnable {
   private int taskNum;
    
   public MyTask(int num) {
       this.taskNum = num;
   }
    
   @Override
   public void run() {
       System.out.println("����ִ��task "+taskNum);
       try {
           Thread.currentThread().sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("task "+taskNum+"ִ�����");
   }
}