package java设计模式.创建复杂对象之建造者模式;

public abstract  class Builder {

    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract Product GetResult();

}
