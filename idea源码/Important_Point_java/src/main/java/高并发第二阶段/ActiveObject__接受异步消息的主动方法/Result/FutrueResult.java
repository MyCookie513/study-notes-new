package 高并发第二阶段.ActiveObject__接受异步消息的主动方法.Result;

/**
 *
 */
public class FutrueResult implements Result {
    private boolean ready=false;
    private Result result;

    /**
     * 这里注入的是含有正是结果的RealResult;
     * @param result
     */
    public synchronized void setResult(Result result){
        this.result=result;
        this.ready=true;
        this.notifyAll();
    }

    @Override
    public synchronized Object getResultValue() {
        while(ready==false){
            try {
                this.wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.result.getResultValue();
    }
}
