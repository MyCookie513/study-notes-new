package 高并发第二阶段.多线程上下文设计模式__ThreadLocal.项目应用;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream.range(0,5).forEach(i->{
                    new  Thread(new ExecutionTask()).start();
                }
        );
    }
}
