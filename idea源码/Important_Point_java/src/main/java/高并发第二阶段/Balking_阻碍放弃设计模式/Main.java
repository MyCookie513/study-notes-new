package 高并发第二阶段.Balking_阻碍放弃设计模式;

import java.util.stream.IntStream;

/**
 * Balking 设计模式：
 * 有多个男孩都想追一个女孩；
 * 一天这个女孩说想邀请一个男孩来他家做客，所有的男孩都想去，
 * 只有一个男孩进去了，
 * 其他的男孩只能在大门外等候，等待下一次这个女孩的邀请
 *
 *
 *
 * 多个消费者--->阻碍放弃设计模式
 */
public class Main {
    public static void main(String[] args) {
        //BalkingData 类相当于这个文件的管家，控制着对这个文件的保存
        final BalkingData balkingData=new BalkingData("file.txt","17864280604");
        //创建了一个专门用于更改文件的线程；
        new Thread(new changeClient(balkingData)).start();
        //创建了几个服务生用于服务这个文件
        IntStream.range(0,3).forEach(i->{
           new Thread(new saveServer(balkingData)).start();
        });
    }
}
