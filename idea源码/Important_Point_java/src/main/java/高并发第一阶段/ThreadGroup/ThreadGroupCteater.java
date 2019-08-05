package 高并发第一阶段.ThreadGroup;

public class ThreadGroupCteater {


    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        System.out.println(Thread.currentThread().getThreadGroup().getName());

        ThreadGroup tg1=new ThreadGroup("tg1");
        new Thread(tg1,"0"){
            @Override
            public void run() {
                while(true){

                    try {
                        System.out.println(getThreadGroup().getName());
                        System.out.println(getThreadGroup().getParent().getName());
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }
}
