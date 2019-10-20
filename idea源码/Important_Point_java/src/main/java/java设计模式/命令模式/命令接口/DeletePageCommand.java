package java设计模式.命令模式.命令接口;

public class DeletePageCommand extends Command {

    @Override
    public void execute() {
        // 找到美工组
        super.pg.find();
        // 删除一个页面
        super.pg.delete();
        // 给出计划
        super.pg.plan();
    }

}