package 高并发第二阶段.多线程上下文设计模式__ThreadLocal.项目应用;

public class QueryFromHttp {
    public  void execute() throws InterruptedException {
        Thread.sleep(1000);
        Context context=ActionContest.getInstance().getConext();
        String card =getCardId(context.getName());
        context.setCard(card);
    }

    /*根据Context获取name，然后继续发送http请求从其他的服务器获取card 信息；
     */
    private String getCardId(String name){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "2626352362623"+Thread.currentThread().getName();
    }
}
