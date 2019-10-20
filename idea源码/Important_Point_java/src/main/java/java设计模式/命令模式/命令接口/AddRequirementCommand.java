package java设计模式.命令模式.命令接口;

public class AddRequirementCommand extends Command {

    @Override
    public void execute() {
        // 找到需求组
        super.rg.find();
        // 增加一份需求
        super.rg.add();
        // 页面要增加
        super.pg.add();
        // 功能也要增加
        super.cg.add();
        //给出计划
        super.rg.plan();
    }
}
