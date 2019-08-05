package 高并发第二阶段.多线程上下文设计模式__ThreadLocal.项目应用;

/**
 * 处理任务为分两步处理的任务；
 *而且第二部任务要借用第一步任务处理的结果 ；
 * 这样的要将这个线程处理的任务放置在自己创建的一个上下文中
 * 在这种处理的情景下，利用ThreadLocal 很方便的实现了线程 的私有保险箱；
 *
 *  * */
public class ExecutionTask implements Runnable {
    //从数据库中查询获取name的信息
    private QueryFromDBAction queryFromDBAction=new QueryFromDBAction();
    //从其他的服务器中异步调用获取其他的信息
    private QueryFromHttp queryFromHttp=new QueryFromHttp();

    @Override
    public void run() {
        Context context=ActionContest.getInstance().getConext();

        //从数据库中查询信息并保存到CONTEXT 中；
        try {
            queryFromDBAction.execute();
            System.out.println("query successful ->the name is :"+context.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            queryFromHttp.execute();
            System.out.println("query successful -> the card is :"+context.getCard());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



}
