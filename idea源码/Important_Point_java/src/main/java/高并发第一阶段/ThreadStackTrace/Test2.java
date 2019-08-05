package 高并发第一阶段.ThreadStackTrace;

import java.util.Arrays;

public class Test2 {
    void test(){

         //从Thread中调用
        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(e->!e.isNativeMethod()).forEach(e->{
            System.out.println("Class:"+e.getClassName()+"  Method :"+e.getMethodName()+" Linenumber:"+e.getLineNumber());
        });

    }
}
