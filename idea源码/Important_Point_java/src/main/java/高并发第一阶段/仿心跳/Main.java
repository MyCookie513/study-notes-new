package 高并发第一阶段.仿心跳;

public class Main {


    public static void main(String[] args) {


        Thread t_main=new Thread(new Runnable() {
            @Override
            public void run() {

                Thread t_daemon=new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while (true){
                            System.out.println("Doing something for health check ");
                            try {
                                Thread.sleep(1_000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }


                    }
                });
                //设置这个子线程为守护线程,主线程退出，子线程自动退出
                t_daemon.setDaemon(true);
                t_daemon.start();

                System.out.println(Thread.currentThread().getName()+"running");
                try {
                    Thread.sleep(6_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"ending");




            }
        });
        t_main.start();

    }


}
