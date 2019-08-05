package 高并发第二阶段.Singleton;

public class SingletonObject6 {

    private  SingletonObject6 instance;


    private SingletonObject6() {

    }


    /**
     *内部静态类的属性成员 不会在加载类的时候被初始化，只有在调用的时候才会被初始化。也就是内部类是lazy load；
     */
    private static  class InstanceHolder{

       private static final  SingletonObject6 instance =new SingletonObject6();
        static {
            System.out.println(" static class is load ");
        }

    }

    public static  SingletonObject6 getInstance(){
        return InstanceHolder.instance;
    }
}
