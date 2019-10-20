package java设计模式.命令模式.命令接口;

import java设计模式.命令模式.项目组分为三个功能组.CodeGroup;
import java设计模式.命令模式.项目组分为三个功能组.PageGroup;
import java设计模式.命令模式.项目组分为三个功能组.RequirementGroup;

public abstract class Command {

    protected RequirementGroup rg = new RequirementGroup();
    protected PageGroup pg = new PageGroup();
    protected CodeGroup cg = new CodeGroup();

    // 只要一个方法，你要我做什么事情
    public abstract void execute();

}