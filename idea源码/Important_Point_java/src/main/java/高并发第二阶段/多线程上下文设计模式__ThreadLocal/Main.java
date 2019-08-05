package 高并发第二阶段.多线程上下文设计模式__ThreadLocal;

public class Main {
    private static ThreadLocal threadLocal=new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return "dfds";
        }
    };
    public static void main(String[] args) throws InterruptedException {
        //threadLocal.set("dfsfds");
        Thread.sleep(1000);
        System.out.println(threadLocal.get());

    }
}
