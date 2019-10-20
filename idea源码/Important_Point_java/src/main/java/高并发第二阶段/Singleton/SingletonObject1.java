package 高并发第二阶段.Singleton;

public class SingletonObject1 {
    /**
     * can't lazy load
     */
    private final static SingletonObject1 instance=new SingletonObject1();

    static {
        System.out.println("singleton 类的初始化");
    }
    public  static SingletonObject1 getInstance(){
        System.out.println("加载返回实例"
                );
        return  instance;
    }
}
