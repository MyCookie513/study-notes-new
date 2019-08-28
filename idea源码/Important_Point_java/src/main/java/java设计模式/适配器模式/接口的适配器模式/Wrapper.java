package java设计模式.适配器模式.接口的适配器模式;

import java设计模式.适配器模式.Source;
import java设计模式.适配器模式.对象的适配器模式.Targetable;

public class Wrapper   implements Targetable {
    private Source source;

    public Wrapper(Source source){
        super();
        this.source = source;
    }
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }

    @Override
    public void method1() {
        source.method1();
    }



}
