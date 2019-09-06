package java设计模式.适配器模式.对象的适配器模式;

import java设计模式.适配器模式.Source;
import java设计模式.适配器模式.类d的适配器模式.Targetable;

/**
 * 再调用上实现简单的适配效果，但不是在根本上的调用；
 */
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
