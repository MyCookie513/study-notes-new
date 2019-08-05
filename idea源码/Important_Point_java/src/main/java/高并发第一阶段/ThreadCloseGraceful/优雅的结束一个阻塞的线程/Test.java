package 高并发第一阶段.ThreadCloseGraceful.优雅的结束一个阻塞的线程;

public class Test {


    public static void main(String[] args) throws InterruptedException {
        Runnable target=new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };

        ThreadService threadService =new ThreadService();
        threadService.execute(target);

        //Thread.sleep(3000);

        System.out.println("3000任务尝试进行中断");
        threadService.shutDown(3000);


    }




}
