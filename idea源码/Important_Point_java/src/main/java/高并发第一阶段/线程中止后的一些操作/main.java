package 高并发第一阶段.线程中止后的一些操作;

public class main {


    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"  将要exit 。\n 将进行通知其他线程的操作\n释放相关资源");

        }));


        int i=0;

        while(true){

            try {
                System.out.println("I am Working ");
                Thread.sleep(3000);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(i==3)
                throw  new RuntimeException("error");

        }
    }




}
