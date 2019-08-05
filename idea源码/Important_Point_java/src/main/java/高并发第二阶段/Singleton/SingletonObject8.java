package 高并发第二阶段.Singleton;

/**
 * 利用枚举的方法来获得单例；
 *
 */

public class SingletonObject8 {
    private SingletonObject8(){

    }


    /**
     *  枚举类型的类和内部静态类相同具有lazy load 的效果，而且只加载一次；
     */

    private enum Singleton{
        INSTANCE;
        private final SingletonObject8 instance;
        Singleton(){
            System.out.println("枚举类型已经被初始化" );
            instance=new SingletonObject8();
        }
        public SingletonObject8 getInstance(){
            return instance;
        }
    }


    public static SingletonObject8 getInstance(){
        return  Singleton.INSTANCE.getInstance();
    }
}
