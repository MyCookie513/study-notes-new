package 高并发第二阶段.Singleton;

public class SingletonObject1 {
    /**
     * can't lazy load
     */
    private final static SingletonObject1 instance=new SingletonObject1();

    public  static SingletonObject1 getInstance(){
        return  instance;
    }


}
