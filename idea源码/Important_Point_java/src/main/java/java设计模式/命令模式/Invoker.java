package java设计模式.命令模式;

import java设计模式.命令模式.命令接口.Command;

//todo   将任务封装成任务接口  然后通过这个类来执行调用任务
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
