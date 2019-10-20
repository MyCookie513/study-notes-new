package java设计模式.命令模式;

import java设计模式.命令模式.命令接口.AddRequirementCommand;
import java设计模式.命令模式.命令接口.Command;

public class Main {

    public static void main(String[] args) {

        // 定义张三为接头人
        Invoker zhangsan = new Invoker();

        System.out.println("----------------客户要求增加一项需求----------------");
        // 客户下命令
        Command command = new AddRequirementCommand();
        // 接头人接受命令
        zhangsan.setCommand(command);
        // 接头人执行命令
        zhangsan.action();
    }
}
