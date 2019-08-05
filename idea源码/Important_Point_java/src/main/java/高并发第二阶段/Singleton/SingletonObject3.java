package 高并发第二阶段.Singleton;

public class SingletonObject3 {

    /**
     * volatile : 作用： volatile在读的过程中，在读的过程看到的写必须完全完成
     * 这样就能保证，instance的实例已经全部完成；
     */

    private volatile SingletonObject3 instance;


    private SingletonObject3() {

    }


    private SingletonObject3 getInstance(){
        if(instance==null){
            synchronized (SingletonObject3.class){
                if(instance==null){
                    instance= new SingletonObject3();
                }
            }

        }

        return instance;
    }
}
