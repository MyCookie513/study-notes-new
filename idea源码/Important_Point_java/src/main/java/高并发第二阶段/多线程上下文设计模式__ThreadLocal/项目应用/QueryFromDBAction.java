package 高并发第二阶段.多线程上下文设计模式__ThreadLocal.项目应用;

public class QueryFromDBAction {


    public void execute( ) throws InterruptedException {

        Context context=ActionContest.getInstance().getConext();
       Thread.sleep(1000);
       String data ="value"+Thread.currentThread().getName();
       context.setName(data);

    }

}
