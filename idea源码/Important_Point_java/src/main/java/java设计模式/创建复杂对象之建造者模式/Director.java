package java设计模式.创建复杂对象之建造者模式;

public class Director {


    /**
     * 决定了组件之间的构建逻辑
     * @param builder
     */
    public void Construct(Builder builder){
        builder.buildPartA();
        builder.buildPartB();
    }

}
