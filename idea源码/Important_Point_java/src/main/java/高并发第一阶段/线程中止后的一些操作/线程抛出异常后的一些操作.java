package 高并发第一阶段.线程中止后的一些操作;

public class 线程抛出异常后的一些操作 {
    public static void main(String[] args) {
      Thread t=  new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int a=6/0;

        });
      t.setUncaughtExceptionHandler((thread,e)->{
          System.out.println(thread.getName()+" 抛出了" +e.getMessage());
      });
      t.start();
    }
}
