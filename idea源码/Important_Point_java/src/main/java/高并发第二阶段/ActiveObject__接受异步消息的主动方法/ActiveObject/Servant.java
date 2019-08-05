package 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject;

import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.ActiveObject.ActiveObject;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.Result.RealResult;
import 高并发第二阶段.ActiveObject__接受异步消息的主动方法.Result.Result;

 public class Servant implements ActiveObject {

    @Override
     public Result makeString(int count, char c) {
         final char[] chars=new char[count];
         for (int i=0;i<count;i++){
             chars[i]=c;
         }
         return new RealResult(new String(chars));
     }

    @Override
    public void displayString(String text) {

        System.out.println("display : "+text);
        try {
            Thread.sleep(100 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
